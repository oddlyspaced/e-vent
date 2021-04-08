package com.oddlyspaced.compass.custom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.LayoutCustomButtonBinding
import com.oddlyspaced.compass.databinding.LayoutEventMinBinding
import com.oddlyspaced.compass.util.DimensionUtils

class MinimisedEvent: CardView {

    private lateinit var binding: LayoutEventMinBinding

    var title = ""
        set(value) {
            field = value
            binding.txEventTitle.text = value
        }

    var time = ""
        set(value) {
            field = value
            binding.txEventDate.text = value
        }

    var location = ""
        set(value) {
            field = value
            binding.txEventLocation.text = value
        }

    var logo = R.drawable.dsc
        set(value) {
            field = value
            binding.imgEventLogo.setImageResource(value)
        }

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
        binding = LayoutEventMinBinding.inflate(LayoutInflater.from(context), this, true)
        binding.consEventMin.setBackgroundColor(Color.parseColor("#FFFFFF"))
        this.elevation = DimensionUtils.floatToDp(context, 2F)
        this.radius = DimensionUtils.floatToDp(context, 12F)
    }

    private fun setAttr(attributes: AttributeSet) {
//        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.CustomButton, 0, 0)
//        try {
//            binding.txCustomButton.text = typedArray.getString(R.styleable.CustomButton_text)
//        }
//        catch (e: Exception) {
//            e.printStackTrace()
//        }
//        finally {
//            typedArray.recycle()
//        }
    }

}