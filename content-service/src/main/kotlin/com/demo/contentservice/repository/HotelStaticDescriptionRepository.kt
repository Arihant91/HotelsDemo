package com.demo.contentservice.repository

import com.demo.contentservice.domain.HotelStaticDescription
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelStaticDescriptionRepository : CrudRepository<HotelStaticDescription, Int>
