package com.oddlyspaced.compass.custom.view

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
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
        binding.etCustomTextField.typeface = ResourcesCompat.getFont(context, R.font.inter_semibold)
    }

    private fun setAttr(attributes: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.CustomTextField, 0, 0)
        try {
            binding.txCustomTextField.text = typedArray.getString(R.styleable.CustomTextField_title)
            binding.etCustomTextField.hint = typedArray.getString(R.styleable.CustomTextField_hint)
            binding.imgCustomTextField.setImageResource(typedArray.getResourceId(R.styleable.CustomTextField_iconSrc, R.drawable.ic_close))
            binding.imgCustomTextField.isVisible = typedArray.getBoolean(R.styleable.CustomTextField_iconVisible, true)
            val inputTypePassword = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            val inputTypeText = InputType.TYPE_CLASS_TEXT
            binding.etCustomTextField.inputType = if (typedArray.getBoolean(R.styleable.CustomTextField_isPassword, false)) inputTypePassword else inputTypeText
            binding.etCustomTextField.typeface = ResourcesCompat.getFont(context, R.font.inter_semibold)
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