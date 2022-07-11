package com.demo.hotel.web

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.service.HotelSearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class GetHotelController {

    @Autowired
    lateinit var hotelSearchService: HotelSearchService

    @GetMapping("/getList")
    fun getListOfHotelCards(
        @RequestParam("location") location: String,
        @RequestParam("checkInDate") checkInDate: String,
        @RequestParam("checkOutDate") checkOutDate: String
    ): Mono<List<HotelCardDetails>>? {
        return hotelSearchService.getListOfHotelCardDetailsAsync(location, checkInDate, checkOutDate)
    }


}