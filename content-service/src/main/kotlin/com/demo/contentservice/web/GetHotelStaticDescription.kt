package com.demo.contentservice.web

import com.demo.contentservice.domain.HotelStaticDescription
import com.demo.contentservice.service.HotelStaticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelStaticDescription {

    @Autowired
    lateinit var hotelStaticService: HotelStaticService;

    @GetMapping("/getListOfHotelsDescriptions")
    fun getListOfHotelStaticDescriptions() : HotelStaticDescription{
        val hotelStaticDescription : HotelStaticDescription = HotelStaticDescription()
        return  hotelStaticDescription
    }
}
