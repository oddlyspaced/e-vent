package com.oddlyspaced.compass.custom.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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

    fun getLogoImageView() = binding.imgEventLogo

    fun setEventLogo(resId: Int) {
        binding.imgEventLogo.setImageResource(resId)
    }

    fun setEventLogo(uri: String) {
        Glide
            .with(context)
            .load(uri)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    resource?.let {
                        binding.imgEventLogo.setImageDrawable(it)
                    }
                    binding.progressBar.isVisible = false
                    return true
                }

            })
            .into(binding.imgEventLogo)
    }

}