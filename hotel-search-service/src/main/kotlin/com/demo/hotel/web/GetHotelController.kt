package com.demo.hotel.web

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.service.AvailabilityService
import com.demo.hotel.service.HotelCardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelController {

    @Autowired
    lateinit var hotelCardService: HotelCardService

    @Autowired
    lateinit var availabilityService: AvailabilityService

    @GetMapping("/gethotelids")
    fun getHotelIds(  @RequestParam("location") location: String,
                      @RequestParam("checkInDate") checkInDate: String,
                      @RequestParam("checkOutDate") checkOutDate: String): MutableList<Int>?{
     return availabilityService.getAvailableHotelIds(location, checkInDate, checkOutDate)
    }


    @GetMapping("/getList")
     fun getListOfHotelCards(
        @RequestParam("location") location: String,
        @RequestParam("checkInDate") checkInDate: String,
        @RequestParam("checkOutDate") checkOutDate: String
    ): List<HotelCardDetails?> {
        return hotelCardService.getListOfHotelCardDetails(location, checkInDate, checkOutDate)
    }


}