package com.oddlyspaced.compass.custom.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.LayoutCustomTextFieldBinding

// Custom Text Field with modified layout
class CustomTextField: ConstraintLayout {

    private companion object {
        private const val TAG = "CustomTextField"
    }
    private lateinit var binding: LayoutCustomTextFieldBinding

    constructor(context: Context): super(context) {
        init(context)
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        init(context)
        setAttr(attr)
    }

    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(context, attr, defStyleAttr) {
        init(context)
        setAttr(attr)
    }

    private fun init(context: Context) {
        binding = LayoutCustomTextFieldBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun setAttr(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.CustomTextField, 0, 0)
        try {
            binding.txCustomTextField.text = typedArray.getString(R.styleable.CustomTextField_title)
            binding.etCustomTextField.hint = typedArray.getString(R.styleable.CustomTextField_hint)
            binding.imgCustomTextField.setImageResource(typedArray.getResourceId(R.styleable.CustomTextField_iconSrc, R.drawable.ic_close))
            binding.imgCustomTextField.isVisible = typedArray.getBoolean(R.styleable.CustomTextField_iconVisible, true)
        }
        catch (e: Exception) {
            Log.e(TAG, "------------------------")
            e.printStackTrace()
            Log.e(TAG, "------------------------")
        }
        finally {
            typedArray.recycle()
        }
    }

    fun getText(): String {
        return binding.etCustomTextField.text.toString()
    }


}