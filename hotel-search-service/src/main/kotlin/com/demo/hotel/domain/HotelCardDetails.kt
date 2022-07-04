package com.demo.hotel.domain

data class HotelCardDetails(
    val id: Int = 0,
    val hotelName: String = "",
    val location: String = "",
    val amenities: List<String> = listOf(""),
    val description: String = "",
    val rating: Int = 0,
    val priceDetails: PriceDetails? = null
) {


}