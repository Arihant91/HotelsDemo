package com.demo.hotel.domain

import javax.management.Descriptor

class HotelCardDetails(val hotelName: String,
                       val location: String,
                       val amenities: List<String>,
                       val description: String,
                       val rating: Int,
                       val priceDetails: PriceDetails? = null) {


}