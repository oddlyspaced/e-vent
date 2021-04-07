package com.oddlyspaced.compass

import android.content.Context
import android.util.TypedValue

class DimensionUtils {
    companion object {
        fun floatToDp(context: Context, dp: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics)
    }
}