package com.demo.availabilityservice.domain

import com.demo.availabilityservice.model.HotelAvailability
import org.springframework.stereotype.Component

@Component
class HotelAvailabilityConverter {

    fun convert(hotelAvailability: HotelAvailability): WebHotelAvailability {
        return WebHotelAvailability(
            hotelAvailability.id,
            hotelAvailability.location,
            hotelAvailability.checkInOutDates
        )
    }
}