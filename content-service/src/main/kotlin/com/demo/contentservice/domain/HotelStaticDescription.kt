package com.demo.contentservice.domain

import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

const val MAGICNUMBER = 5

@Entity
data class HotelStaticDescription(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val hotelName: String = "budapest grand",
    val location: String = "Budapest",
    @ElementCollection
    val amenities: List<String> = listOf("football", "sauna"),
    val description: String = "nice",
    val rating: Int = 5
) {



}
