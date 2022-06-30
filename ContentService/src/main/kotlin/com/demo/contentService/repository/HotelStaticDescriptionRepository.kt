package com.demo.contentService.repository

import com.demo.contentService.domain.HotelStaticDescription
import org.springframework.data.repository.kotlin.CoroutineCrudRepository


interface HotelStaticDescriptionRepository : CoroutineCrudRepository<HotelStaticDescription, Int> {

}