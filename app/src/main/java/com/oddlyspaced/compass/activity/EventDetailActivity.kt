package com.oddlyspaced.compass.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oddlyspaced.compass.R

class EventDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)
    }
}
/*
time
location
title
description
club
facilitator
registration link
registration button
cover image

-> Add to google calendar (automatic)
 */