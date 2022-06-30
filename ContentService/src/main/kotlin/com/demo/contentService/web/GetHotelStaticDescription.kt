package com.demo.contentService.web

import com.demo.contentService.domain.HotelStaticDescription
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelStaticDescription {

    @GetMapping(value = arrayOf("/getListOfHotelsDescriptions"))
    fun getListOfHotelStaticDescriptions() : HotelStaticDescription?{

        return  null
    }
}