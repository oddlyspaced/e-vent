package com.oddlyspaced.compass

import com.oddlyspaced.compass.modal.EventItem

class Global {
    companion object {
        fun getMockData() = arrayListOf(
            EventItem(
                1,
                "Hackathon",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                arrayListOf("Android")
            ),
            EventItem(
                2,
                "Study Jam",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                arrayListOf("jam", "app")
            ),
            EventItem(
                3,
                "Workshop",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                arrayListOf("hacking", "web")
            ),

        )
    }
}