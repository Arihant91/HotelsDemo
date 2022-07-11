package com.demo.availabilityservice.domain

import java.time.LocalDate
import java.util.*
import javax.persistence.Embeddable


@Embeddable
data class CheckInOut(
    var checkIn: LocalDate = LocalDate.of(1970, 1, 1),
    var checkOut: LocalDate = LocalDate.of(1970, 1, 1)
) {

}