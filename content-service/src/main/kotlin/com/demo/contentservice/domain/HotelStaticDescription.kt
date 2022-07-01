package com.demo.contentservice.domain

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

const val MAGICNUMBER = 5

@Entity
class HotelStaticDescription(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val hotelName: String,
    val location: String,
    @ElementCollection
    val amenities: List<String>,
    val description: String,
    val rating: Int
) {
    constructor() : this(1, "", "", listOf(""), "", MAGICNUMBER)


}
