package com.oddlyspaced.compass.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            root = binding.frameAccount.id
        }
        supportFragmentManager.beginTransaction().replace(binding.frameAccount.id, fragment).addToBackStack("AskNum").commit()
    }
}