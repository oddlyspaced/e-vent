package com.oddlyspaced.compass.modal

data class EventItem(
    val id: Int,
    val title: String,
    val clubLogo: String,
    val time: String,
    val location: String,
    val eventId: Int,
    val isIntra: Boolean,
    val tags: ArrayList<String>,
    val description: String,
    val registrationLink: String,
    val banner: String
)