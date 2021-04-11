package com.oddlyspaced.compass.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.ActivityAccountBinding
import com.oddlyspaced.compass.fragment.AskNumFragment

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = AskNumFragment.newInstance().apply {
            arguments = bundleOf(AskNumFragment.ROOT to binding.frameAccount.id)
        }

        supportFragmentManager.beginTransaction().apply {
            replace(binding.frameAccount.id, fragment)
            addToBackStack("AskNum")
        }.commit()
    }
}