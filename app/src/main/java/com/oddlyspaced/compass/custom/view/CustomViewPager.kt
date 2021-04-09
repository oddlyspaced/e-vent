package com.oddlyspaced.compass.custom.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager: ViewPager {

    var isDisabled = false

    constructor(context: Context): super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return !isDisabled && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return !isDisabled && super.onInterceptTouchEvent(ev)
    }
}