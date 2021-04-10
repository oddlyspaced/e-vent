package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.oddlyspaced.compass.Global
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.custom.adapter.EventAdapter
import com.oddlyspaced.compass.databinding.FragmentOverviewBinding

class OverviewFragment: Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    companion object {
        @JvmStatic
        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOverviewBinding.bind(LayoutInflater.from(context).inflate(R.layout.fragment_overview, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvOverviewToday.layoutManager = LinearLayoutManager(context)
        binding.rvOverviewToday.adapter = EventAdapter(Global.getMockData(), activity)
        
        binding.imgOverviewExpand.setOnClickListener {
            binding.rvOverviewToday.layoutManager = LinearLayoutManager(context)
            binding.rvOverviewToday.adapter = EventAdapter(Global.getMockData(), activity)
        }
    }
}