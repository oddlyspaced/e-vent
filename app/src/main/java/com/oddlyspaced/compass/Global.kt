package com.oddlyspaced.compass

import com.oddlyspaced.compass.modal.EventContact
import com.oddlyspaced.compass.modal.EventItem


class Global {
    companion object {
//        fun getMockData() = arrayListOf(
//            EventItem(
//                1000,
//                "ACM",
//                "https://github.com/oddlyspaced/M-pal/blob/main/media/acm.png?raw=true",
//                "Mini Hacks MUJ",
//                "January 29th",
//                "Online",
//                true,
//                1,
//                arrayListOf("hackathon", "development"),
//                "https://res.cloudinary.com/dashed/image/upload/v1611051427/acm/klgjkuqdehb2g4buvprx.png",
//                "MUJ ACM S-CHAP brings to you a series of mini Hackathons to prep you up for the bigger shows.\nCompete with your team of 4 on 29th, 30th and 31st January and drill your coding skills to come out as best creators!\nHackathon Day - 0 is 29th January. Further information would be communicated to the participants\n++Free for ACM Members++ Non ACM Members: Fee Mentioned\nPrizes are cash and kind. Prize pool may increase!\nLast date to register: 28th January, 2021",
//                "https://www.google.com",
//                arrayListOf(
//                    EventContact(
//                        "Vansh Gupta",
//                        "9990100640",
//                    ),
//                    EventContact(
//                        "Abhurup",
//                        "8586070049"
//                    )
//                )
//            ),
//            EventItem(
//                1001,
//                "IEEE",
//                "https://github.com/oddlyspaced/M-pal/blob/main/media/ieee.png?raw=true",
//                "MUJ Hacks",
//                "April 8th",
//                "Online",
//                true,
//                1,
//                arrayListOf("tag1", "tag2"),
//                "banner link",
//                "IEEE S-CHAP MUJ brings you to the yearly Hackathon \"MUJ HACKS\".Compete with your team of 4 from 8th April to 11th April and drill your coding skills to come out as an innovator.\nThe event is free for all.\nCash prizes upto 1l akh rupees\n \nLast date to register is 7 th April so grab your pillows as you are going have some sleepless nights",
//                "https://res.cloudinary.com/dashed/image/upload/v1611051427/acm/klgjkuqdehb2g4buvprx.png",
//                arrayListOf(
//                    EventContact(
//                        "Contact 1",
//                        "9999997777",
//                    ),
//                    EventContact(
//                        "Contact 2",
//                        "87879787988"
//                    )
//                )
//            ),
//            EventItem(
//                1003,
//                "Cinefelia",
//                "https://yt3.ggpht.com/ytc/AAUvwnjlYMk4PgDzmLX7608xjQM7Ywjv0Zekh2mcT4nRIg=s900-c-k-c0x00ffffff-no-rj",
//                "iKhlaas",
//                "April 29th",
//                "TMA PAI Auditorium",
//                true,
//                1,
//                arrayListOf("StagePlay", "Acting"),
//                "https://yt3.ggpht.com/ytc/AAUvwnjlYMk4PgDzmLX7608xjQM7Ywjv0Zekh2mcT4nRIg=s900-c-k-c0x00ffffff-no-rj",
//                "They say that \"The world is a stage\" but we in Cinefilia feel that the stage is our world. It is an intersection between visible and invisible worlds. \nAs the name suggests, Ikhlaas symbolises honesty, truthfulness and playing a character wholeheartedly. Creates a true and a beautiful bond between a performer and audience. \nOur Stage plays have secured the first positions in many out house competitions and we continue to keep growing by writing our own scripts and learning by workshops conducted in the club itself.",
//                "https://www.google.com",
//                arrayListOf(
//                    EventContact(
//                        "Sahik Gupta",
//                        "9992300640",
//                    ),
//                    EventContact(
//                        "Abhurup",
//                        "8456070049"
//                    )
//                )
//            ),
//        )
//    }

        fun getMockData(): ArrayList<EventItem> {
            var eventId = 1000
            val clubs = mapOf(
                Pair(
                    "Developer Student Club",
                    "https://github.com/oddlyspaced/M-pal/blob/main/media/dsc.png?raw=true"
                ),
                Pair(
                    "ACM",
                    "https://github.com/oddlyspaced/M-pal/blob/main/media/acm.png?raw=true"
                ),
                Pair(
                    "IEEE",
                    "https://github.com/oddlyspaced/M-pal/blob/main/media/ieee.png?raw=true"
                ),
            )
            val titles = arrayOf("Hack", "Event", "Muj")
            val months = arrayOf("March", "April", "May")
            val dates = 1..30
            val locations = arrayOf(
                "Online",
                "TMA Pai Auditorium",
                "Dome Building",
                "Room 004 - AB1",
                "Room 123 - AB2"
            )
            val options = arrayOf(true, false)
            val scope = 1..5
            val content =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            val link = "https://www.google.com"

            val list = arrayListOf<EventItem>()

            list.add(
                EventItem(
                    1,
                    "Sphinx",
                    " https://scontent.fdel1-2.fna.fbcdn.net/v/t1.18169-9/21728509_356990308057176_1280822097355511769_n.png?_nc_cat=107&ccb=1-3&_nc_sid=973b4a&_nc_ohc=_sLCA2ku-k0AX_-R1X3&_nc_ht=scontent.fdel1-2.fna&oh=3fa0a47775e5c38f2cbc987518a644c6&oe=609965A6",
                    "Jaipur’s Largest Tech Fest",
                    "May 1",
                    "MNIT Jaipur",
                    true,
                    50,
                    arrayListOf("tech", "dev", "hackathon", "hunt", "techfest"),
                    " https://www.instagram.com/p/B4eVu3HnOl7/ ",
                    " At long last, we're here. 1 is the ultimate number, symbolizing the leader. Each individual craves to attain the position of the ace. The coming three days will be full of enthusiasm, optimism and vitality. Still wondering why? Well there's just 1 day left for Sphinx'21 to win the hearts of technical geeks from all over the nation and motivate the youth with it's fervor. So prepare for a burst of activities, and get ready to prove that your knowledge is worth appreciation in the upcoming intense competitions and compelling techno-battles.",
                    "https://www.google.com",
                    arrayListOf(
                        EventContact(
                            "Anuv Jain",
                            "7894302984",
                        ),
                        EventContact(
                            "Sakhi Mallick",
                            "8456068649"
                        )
                    )
                ),
            )

            list.add(
                EventItem(
                    1000,
                    "Table Tennis",
                    "",
                    " Table tennis trials",
                    "May 27",
                    "TT room AB1",
                    true,
                    1,
                    arrayListOf(
                        "sports", "tennis"
                    ),
                    " ",
                    " Table Tennis team of MUJ is conducting the team trials.\nRules:\n1) Bring your own racket\n2)Wear proper sports shoes\n It will be a knockout challenge that means if you win you move forward else better luck next time .",
                    "https://www.google.com",
                    arrayListOf(
                        EventContact(
                            "Anuv Jain",
                            "7894302984",
                        ),
                        EventContact(
                            "Sakhi Mallick",
                            "8456068649"
                        )
                    )
                ),
            )

            list.add(
                EventItem(
                    1000,
                    "Anant Drishti",
                    " https://static.businessworld.in/article/article_extra_large_image/1605787112_bUAMBu_Manipal_University_Jaipur.jpg",
                    " Space for Everyone",
                    "May 27",
                    "Online",
                    true,
                    1,
                    arrayListOf("Space", "technology"),
                    " https://www.instagram.com/anantdrishti.muj/",
                    " We are happy to announce our new webinar on Space for Everyone by Mr. Sunny Kabrawala, Founder of STAR Technologies.\n Date: 27 May 2021 \nTime: 10:30 AM",
                    "https://www.google.com",
                    arrayListOf(
                        EventContact(
                            "Anuv Jain",
                            "7894302984",
                        ),
                        EventContact(
                            "Sakhi Mallick",
                            "8456068649"
                        )
                    )
                ),
            )

            repeat(20) {
                val club = clubs.entries.random()
                list.add(
                    EventItem(
                        eventId++,
                        club.key,
                        club.value,
                        "${titles.random()} ${titles.random()} ${titles.random()}",
                        "${months.random()} ${dates.random()}",
                        locations.random(),
                        options.random(),
                        scope.random(),
                        arrayListOf(
                            "tag${scope.random()}",
                            "tag${scope.random()}",
                            "tag${scope.random()}"
                        ),
                        "https://res.cloudinary.com/dashed/image/upload/v1611051427/acm/klgjkuqdehb2g4buvprx.png",
                        content,
                        link,
                        arrayListOf(
                            EventContact(
                                "Person 1",
                                "010101",
                            ),
                            EventContact(
                                "Person 2",
                                "10101010"
                            )
                        )
                    )
                )
            }
            return ArrayList(list.shuffled())
        }
    }
}
