package com.demo.contentservice.web

import com.demo.contentservice.domain.HotelStaticDescriptionConverter
import com.demo.contentservice.domain.WebHotelStaticDescription
import com.demo.contentservice.model.HotelStaticDescription
import com.demo.contentservice.repository.HotelStaticDescriptionRepository
import com.demo.contentservice.service.HotelStaticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelStaticDescriptionController {

    @Autowired
    lateinit var hotelStaticService: HotelStaticService

    @Autowired
    lateinit var hotelStaticDescriptionConverter: HotelStaticDescriptionConverter

    @GetMapping("/getListOfHotelsDescriptions")
    fun getListOfHotelStaticDescriptions(
        @RequestParam("location") location: String,
        @RequestParam("checkInDate") checkInDate: String,
        @RequestParam("checkOutDate") checkOutDate: String
    ): WebHotelStaticDescription {

        //dummy data
        val hotelStaticDescription: HotelStaticDescription =
            HotelStaticDescription()
        return hotelStaticDescriptionConverter.converter(
            hotelStaticDescription
        )
    }

    @GetMapping("/save")
    fun save(): String {
        hotelStaticService.saveDummyData()
        return "Done"
    }


    @GetMapping("/returnAll")
    fun getTestData(): Iterable<HotelStaticDescription> {
        return hotelStaticService.getTestData()
    }
}
