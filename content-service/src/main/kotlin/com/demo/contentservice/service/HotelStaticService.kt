package com.demo.contentservice.service

import com.demo.contentservice.domain.HotelStaticDescriptionConverter
import com.demo.contentservice.domain.WebHotelStaticDescription
import com.demo.contentservice.model.HotelStaticDescription
import com.demo.contentservice.repository.HotelStaticDescriptionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class HotelStaticService {

    @Autowired
    lateinit var repository: HotelStaticDescriptionRepository

    @Autowired
    lateinit var webConverter: HotelStaticDescriptionConverter

    fun getHotelsById(ids: List<Int>): MutableList<WebHotelStaticDescription>{
        val listOfHotels: Iterable<HotelStaticDescription> = repository.findAllById(ids)
        val listOfWebHotels : MutableList<WebHotelStaticDescription> = mutableListOf()
        for(hotel in listOfHotels){
            listOfWebHotels.add(webConverter.converter(hotel))
        }

        return listOfWebHotels
    }

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
