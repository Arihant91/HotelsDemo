package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.domain.PriceDetails

class HotelCardService {

    fun getListOfHotelCardDetails(): List<HotelCardDetails> {
        return listOf(
            HotelCardDetails("budapestHotel", "Budapest",
            listOf("football"), "nice place", 5, PriceDetails(500, 600)
            ))
    }
}