package com.demo.contentService.domain

import lombok.Data
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class HotelStaticDescription(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val hotelName: String,
    val location: String,
    @ElementCollection
    val amenities: List<String>,
    val description: String,
    val rating: Int,
) {



}