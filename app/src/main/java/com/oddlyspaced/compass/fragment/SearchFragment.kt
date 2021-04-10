package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.oddlyspaced.compass.Global
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.custom.adapter.EventAdapter
import com.oddlyspaced.compass.databinding.FragmentSearchBinding
import com.oddlyspaced.compass.modal.EventItem
import java.util.*

// TODO : Add filter for sorting events by date
class SearchFragment: Fragment() {

    private lateinit var binding: FragmentSearchBinding
    // this will store the reference list of events in memory for recycler view to use
    private val eventList = arrayListOf<EventItem>()
    // this will hold a modified and filtered out list of events which will be in the adapter
    private val eventListParsed = arrayListOf<EventItem>()
    private var searchQuery = ""
    // list of tags for primary filtering
    private val tags = arrayListOf<String>()
    private var eventType = 3

    private lateinit var adapter: EventAdapter

    companion object {
        @JvmStatic
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.bind(LayoutInflater.from(context).inflate(R.layout.fragment_search, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initPreLoadUi()
        fetchEventList()
        initPostLoadUi()
    }

    /**
     * Ui components which would be initialised before loading data
     */
    private fun initPreLoadUi() {
        binding.imgSearchFilter.setOnClickListener {
            parentFragmentManager.let {
                FilterBottomSheetFragment.newInstance().apply {
                    show(it, "FilterSheet")
                }
            }
        }
    }

    /**
     * Fetches event list from server
     */
    private fun fetchEventList() {
        eventList.addAll(Global.getMockData())
        eventListParsed.addAll(eventList)
    }

    /**
     * Ui components which would be initialised after loading data
     */
    private fun initPostLoadUi() {
        adapter = EventAdapter(
            eventListParsed,
            activity,
            { tag ->
                if (!tags.contains(tag)) {
                    tags.add(tag)
                    populateChips()
                    updateData()
                }
            },
            {

            })
        binding.rvSearchEvents.layoutManager = LinearLayoutManager(context)
        binding.rvSearchEvents.adapter = adapter

        binding.csbSearch.onTextChanged = { query ->
            searchQuery = query
            updateData()
        }

        populateChips()

        parentFragmentManager.setFragmentResultListener(FilterBottomSheetFragment.RESULT_EVENT_TYPE, this) { _, bundle ->
            eventType = bundle.getInt(FilterBottomSheetFragment.RESULT_EVENT_TYPE_VALUE, 3)
            updateData()
        }
    }

    /**
     * Updates data after applying combination of tags and search filtering
     */
    private fun updateData() {
        eventListParsed.clear()
        eventListParsed.apply {
            addAll(filterLocation(filterTags(filterSearch(eventList, searchQuery), tags), eventType))
        }
        adapter.notifyDataSetChanged()
    }

    /**
     * Utility function to filter out items based on query
     * @param query Search query
     */
    private fun filterSearch(items: ArrayList<EventItem>, query: String): ArrayList<EventItem> {
        return arrayListOf<EventItem>().apply {
            addAll(
                items.filter {
                    it.title.toLowerCase(Locale.getDefault()).contains(query.toLowerCase(Locale.getDefault()))
                }
            )
        }
    }

    private fun filterTags(items: ArrayList<EventItem>, queryTags: ArrayList<String>): ArrayList<EventItem> {
        val itemsToRemove = arrayListOf<EventItem>()
        queryTags.forEach { tag->
            items.forEach { item ->
                if (!item.tags.contains(tag)) {
                    itemsToRemove.add(item)
                }
            }
        }
        return items.apply {
            removeAll(itemsToRemove)
        }
    }

    private fun filterLocation(items: ArrayList<EventItem>, typeEvent: Int): ArrayList<EventItem> {
        return when(typeEvent) {
            // all
            3 -> items
            // intra
            else -> arrayListOf<EventItem>().apply {
                addAll(items.filter {
                    it.isIntra == FilterBottomSheetFragment.EVENT_TYPE_VALUES[typeEvent] ?: false
                })
            }
        }
    }

    private fun populateChips() {
        binding.txSearchNoTag.isVisible = tags.isEmpty()
        // TODO : Improve this
        binding.chipGroup.removeAllViews()
        tags.forEachIndexed { index, str ->
            val chip = LayoutInflater.from(context).inflate(R.layout.item_chip, null, false) as Chip
            chip.text = str
            chip.setOnCloseIconClickListener {
                binding.chipGroup.removeViewAt(index)
                tags.removeAt(index)
                binding.chipGroup.removeAllViews()
                populateChips()
                updateData()
            }
            binding.chipGroup.addView(chip)
        }
    }

}