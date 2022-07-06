package com.demo.availabilityservice.web

import com.demo.availabilityservice.model.HotelAvailability
import com.demo.availabilityservice.service.AvailabilityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class AvailabilityServiceController {

    @Autowired
    lateinit var availabilityService: AvailabilityService

    @GetMapping("/seachByTime")
    fun searchByTime(
        @RequestParam("location") location: String,
        @RequestParam("checkInDate") checkInDate: String,
        @RequestParam("checkOutDate") checkOutDate: String,
    ): MutableList<Int> {
        return availabilityService.searchByAvailability(location, checkInDate, checkOutDate)
    }

    @GetMapping("/save")
    fun save(): String{
        return availabilityService.saveDummyData()
    }

    @GetMapping("/returnAll")
    fun returnDataFromDatabase(): Iterable<HotelAvailability> {
        return availabilityService.getData()
    }
}