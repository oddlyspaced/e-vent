package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.util.Log
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
    // list of tags for primary filtering
    private val tags = arrayListOf<String>()

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
            fragmentManager?.let {
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
        adapter = EventAdapter(eventListParsed)
        binding.rvSearchEvents.layoutManager = LinearLayoutManager(context)
        binding.rvSearchEvents.adapter = adapter

        binding.csbSearch.onTextChanged = { query ->
            filterSearch(query)
        }

        populateChips(tags)
    }

    /**
     * Utility function to filter out items based on query
     * @param query Search query
     */
    private fun filterSearch(query: String) {
        eventListParsed.clear()
        eventListParsed.addAll(
            eventList.filter {
                it.title.toLowerCase(Locale.getDefault()).contains(query.toLowerCase(Locale.getDefault()))
            }
        )
        adapter.notifyDataSetChanged()
    }

    private fun populateChips(chipTitles: ArrayList<String>) {
        binding.txSearchNoTag.isVisible = chipTitles.isEmpty()
        chipTitles.forEachIndexed { index, str ->
            val chip = LayoutInflater.from(context).inflate(R.layout.item_chip, null, false) as Chip
            chip.text = str
            chip.setOnCloseIconClickListener {
                binding.chipGroup.removeViewAt(index)
                tags.removeAt(index)
                binding.chipGroup.removeAllViews()
                populateChips(tags)
            }
            binding.chipGroup.addView(chip)
        }
    }

}