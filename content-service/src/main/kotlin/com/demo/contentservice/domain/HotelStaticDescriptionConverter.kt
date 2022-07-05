package com.demo.contentservice.domain

import com.demo.contentservice.model.HotelStaticDescription
import org.springframework.stereotype.Component

@Component
class HotelStaticDescriptionConverter {

    fun converter(hotelStaticDescription: HotelStaticDescription): WebHotelStaticDescription {
        return WebHotelStaticDescription(
            hotelStaticDescription.id,
            hotelStaticDescription.hotelName,
            hotelStaticDescription.location,
            hotelStaticDescription.amenities,
            hotelStaticDescription.description,
            hotelStaticDescription.rating
        )
    }
}