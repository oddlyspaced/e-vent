package com.oddlyspaced.compass.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.slider.Slider
import com.oddlyspaced.compass.databinding.SheetFilterBinding

class FilterBottomSheetFragment: BottomSheetDialogFragment() {

    private lateinit var binding: SheetFilterBinding

    companion object {
        @JvmStatic
        fun newInstance(): FilterBottomSheetFragment {
            return FilterBottomSheetFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SheetFilterBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cbFilterInterCollege.setOnCheckedChangeListener { _, checked ->
            checkEventTypeChecks()
            binding.viewFilterScopeDisable.isVisible = !checked
        }
        binding.cbFilterIntraCollege.setOnCheckedChangeListener { _, checked ->
            checkEventTypeChecks()
        }
        binding.cbFilterIntraCollege.isChecked = true

        val scopes = arrayOf("District", "City", "State", "National", "International")
        binding.sliderFilterScope.addOnChangeListener { _, value, _ ->
            binding.txFilterScope.text = scopes[value.toInt()]
        }

        binding.cbFilterFree.setOnCheckedChangeListener { _, checked ->
            checkCostChecks()
        }
        binding.cbFilterPaid.setOnCheckedChangeListener { _, checked ->
            checkCostChecks()
        }
        binding.cbFilterFree.isChecked = true
        binding.cbFilterPaid.isChecked = true

        binding.viewFilterScopeDisable.setOnTouchListener { _, _ ->
            Toast.makeText(context, "Inter College events must be selected for this to work!", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun checkEventTypeChecks() {
        if (!(binding.cbFilterIntraCollege.isChecked or binding.cbFilterInterCollege.isChecked)) {
            Toast.makeText(context, "Atleast one should be selected!", Toast.LENGTH_SHORT).show()
            binding.cbFilterIntraCollege.isChecked = true
        }
    }

    private fun checkCostChecks() {
        if (!(binding.cbFilterFree.isChecked or binding.cbFilterPaid.isChecked)) {
            Toast.makeText(context, "Atleast one should be selected!", Toast.LENGTH_SHORT).show()
            binding.cbFilterFree.isChecked = true
        }
    }
}