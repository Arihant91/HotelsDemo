package com.demo.hotel.web

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.service.AvailabilityService
import com.demo.hotel.service.HotelCardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelController {

    @Autowired
    lateinit var hotelCardService: HotelCardService



//    @GetMapping("/getList")
//     fun getListOfHotelCards(
//        @RequestParam("location") location: String,
//        @RequestParam("checkInDate") checkInDate: String,
//        @RequestParam("checkOutDate") checkOutDate: String
//    ): MutableList<HotelCardDetails>?{
//        return hotelCardService.getListOfHotelCardDetails(location, checkInDate, checkOutDate)
//    }

    @GetMapping("/getList")
    fun getListOfHotelCards(
        @RequestParam("location") location: String,
        @RequestParam("checkInDate") checkInDate: String,
        @RequestParam("checkOutDate") checkOutDate: String
    ): Any{
        //ResponseEntity<List<HotelCardDetails>>
        val respone = hotelCardService.getListOfHotelCardDetails(location, checkInDate, checkOutDate)
        return ResponseEntity<List<HotelCardDetails>>(respone, HttpStatus.OK)
    }


}