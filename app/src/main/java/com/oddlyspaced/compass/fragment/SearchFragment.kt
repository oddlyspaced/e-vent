package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.oddlyspaced.compass.Global
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.custom.EventAdapter
import com.oddlyspaced.compass.databinding.FragmentOverviewBinding
import com.oddlyspaced.compass.databinding.FragmentSearchBinding
import com.yuyakaido.android.cardstackview.CardStackLayoutManager

class SearchFragment: Fragment() {

    private lateinit var binding: FragmentSearchBinding

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
        binding.rvSearchEvents.layoutManager = LinearLayoutManager(context)
        binding.rvSearchEvents.adapter = EventAdapter(Global.getMockData())
        binding.imgSearchFilter.setOnClickListener {
            fragmentManager?.let {
                FilterBottomSheetFragment.newInstance().apply {
                    show(it, "FilterSheet")
                }
            }
        }
    }
}