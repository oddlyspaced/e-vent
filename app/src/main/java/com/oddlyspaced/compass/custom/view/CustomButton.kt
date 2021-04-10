package com.oddlyspaced.compass.custom.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.LayoutCustomButtonBinding
import com.oddlyspaced.compass.util.DimensionUtils

class CustomButton: CardView {

    private lateinit var binding: LayoutCustomButtonBinding

    constructor(ctx: Context) : super(ctx) {
        init(ctx)
    }

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {
        init(ctx)
        setAttr(attr)
    }

    constructor(ctx: Context, attr: AttributeSet, defStyleAttr: Int) : super(ctx, attr, defStyleAttr) {
        init(ctx)
        setAttr(attr)
    }

    private fun init(context: Context) {
        binding = LayoutCustomButtonBinding.inflate(LayoutInflater.from(context), this, true)
        binding.consCustomButton.setBackgroundColor(context.getColor(R.color.accent))
        this.elevation = DimensionUtils.floatToDp(context, 8F)
        this.radius = DimensionUtils.floatToDp(context, 24F)
    }

    private fun setAttr(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.CustomButton, 0, 0)
        try {
            binding.txCustomButton.text = typedArray.getString(R.styleable.CustomButton_text)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
        finally {
            typedArray.recycle()
        }
    }

}