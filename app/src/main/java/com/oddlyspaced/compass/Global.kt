package com.oddlyspaced.compass

import com.oddlyspaced.compass.modal.EventItem

class Global {
    companion object {
        fun getMockData() = arrayListOf(
            EventItem(
                "Hackathon by IEEE",
                "April 08 - 12:00 PM",
                "Dome building",
                R.drawable.dsc
            ),
            EventItem(
                "Kotlin workshop by DSC",
                "April 10 - 1:00 PM",
                "Academic Block 1- Room 223",
                R.drawable.dsc
            ),
            EventItem(
                "Interbranch Tennis tournament",
                "April 21 - 9:00 AM",
                "College Tennis court",
                R.drawable.dsc,
            ),
            EventItem(
                "Plantation drive by Rotary Club MUJ ",
                "April 10 - 10:00 AM",
                "College Gate",
                R.drawable.dsc,
            ),
            EventItem(
                "Codethon by IEEE(online event)",
                "May 2 - 9:00 PM",
                "Codechef",
                R.drawable.dsc
            ),
            EventItem(
                "Kriya by Yes+ Muj",
                "Everyday",
                "AB2 - Room 321",
                R.drawable.dsc,
            ),
            EventItem(
                "ACM Working comittee interviews",
                "May 3 - 9:00 AM",
                "Old Mess",
                R.drawable.dsc
            ),
            EventItem(
                "Hacking workshop by Kevin Mitnick",
                "April 21 - 9:00 AM",
                "TMC Pai Auditorium",
                R.drawable.dsc
            )
        )
    }
}