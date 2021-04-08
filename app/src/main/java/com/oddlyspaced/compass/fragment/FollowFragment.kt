package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.FragmentFollowBinding

class FollowFragment: Fragment() {

    private lateinit var binding: FragmentFollowBinding

    companion object {
        @JvmStatic
        fun newInstance(): FollowFragment {
            return FollowFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFollowBinding.bind(LayoutInflater.from(context).inflate(R.layout.fragment_follow, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val categories = arrayListOf("DSC", "ACM", "IEEE", "Web Dev", "Android")
        categories.forEach {
            val chip = LayoutInflater.from(context).inflate(R.layout.item_chip, null, false) as Chip
            chip.text = it
            binding.chipGroup.addView(chip)
        }
    }

}