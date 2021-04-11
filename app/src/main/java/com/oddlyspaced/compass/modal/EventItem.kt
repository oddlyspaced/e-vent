package com.oddlyspaced.compass.modal

data class EventItem(
    val eventId: Int,
    val clubName: String,
    val clubLogo: String,
    val title: String,
    val time: String,
    val location: String,
    val isIntra: Boolean,
    val scope: Int,
    val tags: ArrayList<String>,
    val banner: String,
    val description : String,
    val registrationLink: String,
    val contact: ArrayList<EventContact>
)