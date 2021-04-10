package com.oddlyspaced.compass

import com.oddlyspaced.compass.modal.EventContact
import com.oddlyspaced.compass.modal.EventItem

class Global {
    companion object {
        fun getMockData() = arrayListOf(
            EventItem(
                1,
                "ACM",
                "https://github.com/oddlyspaced/M-pal/blob/main/media/acm.png?raw=true",
                1000,
                "Mini Hacks MUJ",
                "January 29th",
                "Online",
                true,
                arrayListOf("hackathon", "development"),
                "https://res.cloudinary.com/dashed/image/upload/v1611051427/acm/klgjkuqdehb2g4buvprx.png",
                "MUJ ACM S-CHAP brings to you a series of mini Hackathons to prep you up for the bigger shows.\nCompete with your team of 4 on 29th, 30th and 31st January and drill your coding skills to come out as best creators!\nHackathon Day - 0 is 29th January. Further information would be communicated to the participants\n++Free for ACM Members++ Non ACM Members: Fee Mentioned\nPrizes are cash and kind. Prize pool may increase!\nLast date to register: 28th January, 2021",
                "https://www.google.com",
                arrayListOf(
                    EventContact(
                        "Vansh Gupta",
                        "9990100640",
                    ),
                    EventContact(
                        "Abhurup",
                        "8586070049"
                    )
                )
            ),
            EventItem(
                2,
                "IEEE",
                "https://github.com/oddlyspaced/M-pal/blob/main/media/ieee.png?raw=true",
                1000,
                "MUJ Hacks",
                "April 8th",
                "Online",
                true,
                arrayListOf("tag1", "tag2"),
                "banner link",
                "IEEE S-CHAP MUJ brings you to the yearly Hackathon \"MUJ HACKS\".Compete with your team of 4 from 8th April to 11th April and drill your coding skills to come out as an innovator.\nThe event is free for all.\nCash prizes upto 1l akh rupees\n \nLast date to register is 7 th April so grab your pillows as you are going have some sleepless nights",
                "https://res.cloudinary.com/dashed/image/upload/v1611051427/acm/klgjkuqdehb2g4buvprx.png",
                arrayListOf(
                    EventContact(
                        "Contact 1",
                        "9999997777",
                    ),
                    EventContact(
                        "Contact 2",
                        "87879787988"
                    )
                )
            ),
        )
    }
}