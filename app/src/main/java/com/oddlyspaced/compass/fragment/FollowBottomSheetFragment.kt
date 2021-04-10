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
import com.oddlyspaced.compass.databinding.SheetConfirmFollowBinding
import com.oddlyspaced.compass.databinding.SheetFilterBinding

class FollowBottomSheetFragment: BottomSheetDialogFragment() {

    private lateinit var binding: SheetConfirmFollowBinding

    companion object {
        @JvmStatic
        fun newInstance(): FollowBottomSheetFragment {
            return FollowBottomSheetFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SheetConfirmFollowBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}