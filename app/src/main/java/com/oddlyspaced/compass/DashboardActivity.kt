package com.oddlyspaced.compass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.oddlyspaced.compass.custom.CustomTabsAdapter
import com.oddlyspaced.compass.databinding.ActivityDashboardBinding
import com.oddlyspaced.compass.fragment.OverviewFragment

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CustomTabsAdapter(mutableListOf("Overview", "Following", "Events", "Events", "events", "events"))
        binding.rvTabs.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTabs.adapter = adapter

        binding.viewPagerDashboard.adapter = ViewPagerAdapter(arrayListOf(OverviewFragment.newInstance()), supportFragmentManager)
    }

    inner class ViewPagerAdapter(private val fragments: ArrayList<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment = fragments[position]
        override fun getCount(): Int = fragments.size
    }
}