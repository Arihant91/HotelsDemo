package com.demo.availabilityservice.model

import com.demo.availabilityservice.domain.CheckInOut
import com.demo.availabilityservice.repository.HotelAvailabilityRepository
import javax.persistence.CollectionTable
import javax.persistence.ElementCollection
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class HotelAvailability(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val location: String = "",
    @ElementCollection
    var checkInOutDates: MutableList<CheckInOut> = mutableListOf()
){



}