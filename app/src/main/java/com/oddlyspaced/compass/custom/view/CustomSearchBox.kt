package com.oddlyspaced.compass.custom.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.widget.addTextChangedListener
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.LayoutSearchBinding
import com.oddlyspaced.compass.util.DimensionUtils

class CustomSearchBox: CardView {

    private companion object {
        const val TAG = "CustomSearchBox"
    }

    private lateinit var binding: LayoutSearchBinding
    var onTextChanged = { text: String ->
        Log.d(TAG, "Text $text")
        Unit
    }

    constructor(ctx: Context) : super(ctx) {
        init(ctx)
    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
        init(ctx)
    }

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(ctx, attr, defStyleAttr) {
        init(ctx)
    }

    private fun init(context: Context) {
        binding = LayoutSearchBinding.inflate(LayoutInflater.from(context), this, true)
        binding.consCustomSearch.setBackgroundColor(context.getColor(R.color.background))
        this.elevation = DimensionUtils.floatToDp(context, 2F)
        this.radius = DimensionUtils.floatToDp(context, 12F)

        attachListeners()
    }

    private fun attachListeners() {
        binding.etSearch.addTextChangedListener {
            onTextChanged(it?.toString() ?: "")
        }
    }

}