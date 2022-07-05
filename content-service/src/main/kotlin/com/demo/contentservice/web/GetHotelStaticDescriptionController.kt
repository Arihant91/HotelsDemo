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
    lateinit var repository: HotelStaticDescriptionRepository

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
        repository.saveAll(
            listOf(
                HotelStaticDescription(
                    0,
                    "Grand Budapest hotel",
                    "Budapest",
                    listOf("football", "sauna"),
                    "nice",
                    5
                ),
                HotelStaticDescription(
                    0,
                    "Hilton",
                    "Budapest",
                    listOf("football", "sauna"),
                    "nice",
                    5
                ),
                HotelStaticDescription(
                    0,
                    "Antonia",
                    "Belgrad",
                    listOf("football", "sauna"),
                    "nice",
                    5
                ),
                HotelStaticDescription(
                    0,
                    "Beverly",
                    "Budapest",
                    listOf("football", "sauna"),
                    "nice",
                    5
                ),
                HotelStaticDescription(
                    0,
                    "TiszaHotel",
                    "Szeged",
                    listOf("football", "sauna"),
                    "nice",
                    4
                ),
                HotelStaticDescription(
                    0,
                    "Hansa",
                    "Frankfurt",
                    listOf("football", "sauna"),
                    "nice",
                    5
                )
            )
        )

        return "Done"
    }


    @GetMapping("/returnAll")
    fun getTestData(): Iterable<HotelStaticDescription> {
        var rep = repository.findAll()
        return rep

    }
}
