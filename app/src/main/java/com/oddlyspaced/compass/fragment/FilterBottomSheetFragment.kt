package com.oddlyspaced.compass.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.oddlyspaced.compass.R
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}