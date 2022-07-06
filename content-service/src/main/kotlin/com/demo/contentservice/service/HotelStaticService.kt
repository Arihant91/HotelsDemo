package com.demo.contentservice.service

import com.demo.contentservice.model.HotelStaticDescription
import com.demo.contentservice.repository.HotelStaticDescriptionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class HotelStaticService {

    @Autowired
    lateinit var repository: HotelStaticDescriptionRepository

    fun saveDummyData(){
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
                ),
                HotelStaticDescription(
                    0,
                    "Black Lagoon",
                    "Taiwan",
                    listOf("football", "sauna"),
                    "nice",
                    5
                )
            )
        )
    }

    fun getTestData(): Iterable<HotelStaticDescription>{
        return repository.findAll()
    }

}
