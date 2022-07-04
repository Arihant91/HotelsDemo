package com.demo.hotel.domain

class HotelCardDetails(
    val id: Int,
    val hotelName: String,
    val location: String,
    val amenities: List<String>,
    val description: String,
    val rating: Int,
    val priceDetails: PriceDetails? = null
) {

    constructor() : this(0,"", "", listOf(""), "", 6)


}