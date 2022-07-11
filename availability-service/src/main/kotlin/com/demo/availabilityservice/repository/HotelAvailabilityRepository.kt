package com.demo.availabilityservice.repository

import com.demo.availabilityservice.model.HotelAvailability
import org.springframework.data.repository.CrudRepository

interface HotelAvailabilityRepository :
    CrudRepository<HotelAvailability, Int> {
}