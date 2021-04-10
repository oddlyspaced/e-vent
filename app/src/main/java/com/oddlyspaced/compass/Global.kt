package com.oddlyspaced.compass

import com.oddlyspaced.compass.modal.EventItem

class Global {
    companion object {

        const val VALUE_TYPE_EVENT_INTER = 1
        const val VALUE_TYPE_EVENT_INTRA = 2

        fun getMockData() = arrayListOf(
            EventItem(
                1,
                "Hackathon inter",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                false,
                arrayListOf("Android"),
                "Ipsum Lore",
                "linkkk",
                "linkkk"
            ),
            EventItem(
                2,
                "Study Jam inter",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                false,
                arrayListOf("jam", "app"),
                "Ipsum Lore",
                "linkkk",
                "linkkk"
            ),
            EventItem(
                3,
                "Workshop inter",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                false,
                arrayListOf("hacking", "web"),
                "Ipsum Lore",
                "linkkk",
                "linkkk"
            ),
            EventItem(
                4,
                "Hackathon 123 intra",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                true,
                arrayListOf("Android"),
                "Ipsum Lore",
                "linkkk",
                "linkkk"
            ),
            EventItem(
                5,
                "Study Jam intra",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                true,
                arrayListOf("jam", "app"),
                "Ipsum Lore",
                "linkkk",
                "linkkk"
            ),
            EventItem(
                6,
                "Worksho p intra",
                "https://raw.githubusercontent.com/oddlyspaced/covid19-android/master/screenshots/icon.png",
                "April 08 - 12:00 PM",
                "Dome building",
                1001,
                true,
                arrayListOf("hacking", "web"),
                "Ipsum Lore",
                "linkkk",
                "linkkk",
            ),
        )
    }
}