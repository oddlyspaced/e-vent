package com.oddlyspaced.compass.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.oddlyspaced.compass.databinding.LayoutCustomTextFieldBinding

// Custom Text Field with modified layout
class CustomTextField: ConstraintLayout {

    private lateinit var binding: LayoutCustomTextFieldBinding

    constructor(context: Context): super(context) {
        init(context)
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        init(context)
    }

    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(context, attr, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        binding = LayoutCustomTextFieldBinding.inflate(LayoutInflater.from(context), this, true)
    }


}