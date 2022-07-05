package com.demo.contentservice.repository

import com.demo.contentservice.model.HotelStaticDescription
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelStaticDescriptionRepository : CrudRepository<HotelStaticDescription, Int>{

    fun findByHotelName(hotelName: String): Iterable<HotelStaticDescription>
}
