package com.oddlyspaced.compass.fragment

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.oddlyspaced.compass.databinding.SheetFilterBinding

class FilterBottomSheetFragment: BottomSheetDialogFragment() {

    private lateinit var binding: SheetFilterBinding

    companion object {
        const val RESULT_EVENT_TYPE = "event_type"
        const val RESULT_EVENT_TYPE_VALUE = "event_type_value"
        val EVENT_TYPE_VALUES = mapOf(
            // calc , intra
            Pair(2, true),
            Pair(1, false)
        )

        const val RESULT_SCOPE = "scope"
        const val RESULT_COST_TYPE = "cost_type"
        const val RESULT_COST_TYPE_VALUE = "cost_type_value"

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
        binding.cbFilterIntraCollege.setOnCheckedChangeListener { _, _ ->
            checkEventTypeChecks()
        }
        binding.cbFilterIntraCollege.isChecked = true

        val scopes = arrayOf("District", "City", "State", "National", "International")
        binding.sliderFilterScope.addOnChangeListener { _, value, _ ->
            binding.txFilterScope.text = scopes[value.toInt()]
        }

        binding.cbFilterFree.setOnCheckedChangeListener { _, _ ->
            checkCostChecks()
        }
        binding.cbFilterPaid.setOnCheckedChangeListener { _, _ ->
            checkCostChecks()
        }
        binding.cbFilterFree.isChecked = true
        binding.cbFilterPaid.isChecked = true

        binding.viewFilterScopeDisable.setOnTouchListener { _, _ ->
            Toast.makeText(context, "Inter College events must be selected for this to work!", Toast.LENGTH_SHORT).show()
            true
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        setEventTypeResult()
        setCostTypeResult()
    }

    private fun checkEventTypeChecks() {
        if (calculateEventTypeTotal() == 0) {
            Toast.makeText(context, "At least one should be selected!", Toast.LENGTH_SHORT).show()
            binding.cbFilterIntraCollege.isChecked = true
        }
    }

    private fun checkCostChecks() {
        if (calculateCostTypeTotal() == 0) {
            Toast.makeText(context, "At least one should be selected!", Toast.LENGTH_SHORT).show()
            binding.cbFilterFree.isChecked = true
        }
    }

    private fun calculateEventTypeTotal(): Int {
        // 0 -> not possible
        // 1 -> inter college
        // 2 -> intra college
        // 3 -> all
        var value = 0
        value += if (binding.cbFilterInterCollege.isChecked) 1 else 0
        value += if (binding.cbFilterIntraCollege.isChecked) 2 else 0
        return value
    }

    private fun calculateCostTypeTotal(): Int {
        // 0 -> not possible
        // 1 -> free
        // 2 -> paid
        // 3 -> all
        var value = 0
        value += if (binding.cbFilterFree.isChecked) 1 else 0
        value += if (binding.cbFilterPaid.isChecked) 2 else 0
        return value
    }

    private fun setEventTypeResult() {
        setFragmentResult(RESULT_EVENT_TYPE, bundleOf(RESULT_EVENT_TYPE_VALUE to calculateEventTypeTotal()))
    }

    private fun setCostTypeResult() {
        setFragmentResult(RESULT_COST_TYPE, bundleOf(RESULT_COST_TYPE_VALUE to calculateCostTypeTotal()))
    }
}