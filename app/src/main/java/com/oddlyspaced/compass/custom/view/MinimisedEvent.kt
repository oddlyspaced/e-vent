package com.oddlyspaced.compass.custom.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.custom.adapter.CustomTagsAdapter
import com.oddlyspaced.compass.databinding.LayoutEventMinBinding
import com.oddlyspaced.compass.util.DimensionUtils

class MinimisedEvent: CardView {

    private companion object {
        const val TAG = "MinimisedEvent"
    }

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

    var tags = arrayOf("Android", "App")
        set(value) {
            field = value
            binding.rvEventTags.adapter = CustomTagsAdapter(value, onTagClicked, onTagLongClick)
        }

    var onTagClicked = { tag: String ->
        // click filter, long press follow
        Log.d(TAG, "$tag Pressed")
        Unit
    }
        set(value) {
            field = value
            binding.rvEventTags.adapter = CustomTagsAdapter(tags, value, onTagLongClick)
        }

    var onTagLongClick = { tag: String ->
        Log.d(TAG, "$tag Long Pressed")
        Unit
    }
        set(value) {
            field = value
            binding.rvEventTags.adapter = CustomTagsAdapter(tags, onTagClicked, value)
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
        binding = LayoutEventMinBinding.inflate(LayoutInflater.from(context), this, true)
        binding.consEventMin.setBackgroundColor(ContextCompat.getColor(context, R.color.event_card_background))
        this.elevation = DimensionUtils.floatToDp(context, 2F)
        this.radius = DimensionUtils.floatToDp(context, 12F)

        binding.rvEventTags.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvEventTags.adapter = CustomTagsAdapter(tags, onTagClicked, onTagLongClick)
    }

}