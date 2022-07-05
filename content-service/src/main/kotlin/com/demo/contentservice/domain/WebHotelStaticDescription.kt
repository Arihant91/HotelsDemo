package com.demo.contentservice.domain

class WebHotelStaticDescription(
    val id: Int,
    val hotelName: String,
    val location: String,
    val amenities: List<String>,
    val description: String,
    val rating: Int
) {

}