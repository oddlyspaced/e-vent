package com.oddlyspaced.compass

import com.oddlyspaced.compass.modal.EventContact
import com.oddlyspaced.compass.modal.EventItem

class Global {
    companion object {
        fun getMockData() = arrayListOf(
            EventItem(
                1000,
                "ACM",
                "https://github.com/oddlyspaced/M-pal/blob/main/media/acm.png?raw=true",
                "Mini Hacks MUJ",
                "January 29th",
                "Online",
                true,
                1,
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
                1001,
                "IEEE",
                "https://github.com/oddlyspaced/M-pal/blob/main/media/ieee.png?raw=true",
                "MUJ Hacks",
                "April 8th",
                "Online",
                true,
                1,
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
            EventItem(
                1003,
                "Cinefelia",
                "https://www.instagram.com/cinefiliamuj/",
                "iKhlaas",
                "April 29th",
                "TMA PAI Auditorium",
                true,
                1,
                arrayListOf("StagePlay", "Acting"),
                "https://yt3.ggpht.com/ytc/AAUvwnjlYMk4PgDzmLX7608xjQM7Ywjv0Zekh2mcT4nRIg=s900-c-k-c0x00ffffff-no-rj",
                "They say that \"The world is a stage\" but we in Cinefilia feel that the stage is our world. It is an intersection between visible and invisible worlds. \nAs the name suggests, Ikhlaas symbolises honesty, truthfulness and playing a character wholeheartedly. Creates a true and a beautiful bond between a performer and audience. \nOur Stage plays have secured the first positions in many out house competitions and we continue to keep growing by writing our own scripts and learning by workshops conducted in the club itself.",
                "https://www.google.com",
                arrayListOf(
                    EventContact(
                        "Sahik Gupta",
                        "9992300640",
                    ),
                    EventContact(
                        "Abhurup",
                        "8456070049"
                    )
                )
            ),
        )
    }
}