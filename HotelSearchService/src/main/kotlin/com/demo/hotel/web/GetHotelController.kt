package com.demo.hotel.web

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.service.HotelCardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelController {

    val hotelCardService : HotelCardService = HotelCardService()

    @GetMapping(value = arrayOf("/getList"))
    fun getListOfHotelCards() : List<HotelCardDetails>{
        return hotelCardService.getListOfHotelCardDetails()
    }

}