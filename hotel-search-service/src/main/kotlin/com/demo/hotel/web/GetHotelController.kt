package com.demo.hotel.web

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.service.HotelCardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelController {

    val hotelCardService: HotelCardService = HotelCardService()

    @GetMapping("/getList")
     fun getListOfHotelCards(
        @RequestParam("location") location: String,
        @RequestParam("checkInDate") checkInDate: String,
        @RequestParam("checkOutDate") checkOutDate: String
    ): List<HotelCardDetails> {
        return hotelCardService.getListOfHotelCardDetails(location, checkInDate, checkOutDate)
    }

}