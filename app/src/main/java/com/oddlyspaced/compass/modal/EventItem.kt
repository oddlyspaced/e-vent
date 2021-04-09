package com.oddlyspaced.compass.modal

data class EventItem(
    val id: Int,
    val title: String,
    val clubLogo: String,
    val time: String,
    val location: String,
    val eventId: Int,
    val tags: ArrayList<String>
)