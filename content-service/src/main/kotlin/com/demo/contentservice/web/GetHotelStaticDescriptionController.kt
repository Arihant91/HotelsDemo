package com.demo.contentservice.web

import com.demo.contentservice.domain.WebHotelStaticDescription
import com.demo.contentservice.model.HotelStaticDescription
import com.demo.contentservice.service.HotelStaticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHotelStaticDescriptionController {

    @Autowired
    lateinit var hotelStaticService: HotelStaticService

    @GetMapping("/getHotelDescriptions")
    fun getHotelsByIds(@RequestParam("ids") ids: List<Int>): Iterable<WebHotelStaticDescription> {

        return hotelStaticService.getHotelsById(ids)
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
