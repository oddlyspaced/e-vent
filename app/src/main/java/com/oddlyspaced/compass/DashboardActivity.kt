package com.oddlyspaced.compass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.oddlyspaced.compass.custom.CustomTabsAdapter
import com.oddlyspaced.compass.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CustomTabsAdapter(mutableListOf("Overview", "Following", "Events", "Events", "events", "events"))
        binding.rvTabs.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTabs.adapter = adapter
    }
}