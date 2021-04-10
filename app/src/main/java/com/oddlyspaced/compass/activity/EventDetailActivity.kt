package com.oddlyspaced.compass.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.oddlyspaced.compass.R
import com.oddlyspaced.compass.databinding.ActivityEventDetailBinding
import java.lang.Exception

class EventDetailActivity : AppCompatActivity() {

    companion object {
        const val CLUB_LOGO = "club_logo"
        const val CLUB_NAME = "club_name"
        const val EVENT_NAME = "event_title"
        const val EVENT_DATE = "event_date"
        const val EVENT_LOCATION = "event_location"
        const val EVENT_BANNER = "event_banner"
        const val EVENT_DESC = "event_desc"
        const val REGIS_LINK = "registration_link"
     }

    private lateinit var binding: ActivityEventDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        try {
            intent.run {
                Glide.with(applicationContext).load(getStringExtra(CLUB_LOGO)).into(binding.imgDetailsLogo)
                Glide.with(applicationContext).load(getStringExtra(EVENT_BANNER)).into(binding.imgDetailsBanner)
                binding.txDetailsClubName.text = getStringExtra(CLUB_NAME)
                binding.txDetailsTitle.text = getStringExtra(EVENT_NAME)
                binding.txDetailsCalendar.text = getStringExtra(EVENT_DATE)
                binding.txDetailsLocation.text = getStringExtra(EVENT_LOCATION)
                binding.txDetailsDesc.text = getStringExtra(EVENT_DESC)
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }

}