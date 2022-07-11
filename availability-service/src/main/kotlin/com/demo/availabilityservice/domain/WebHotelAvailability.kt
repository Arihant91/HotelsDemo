package com.demo.availabilityservice.domain

class WebHotelAvailability(
    val id: Int,
    val location: String,
    var checkInOutDates: MutableList<CheckInOut>
) {
}