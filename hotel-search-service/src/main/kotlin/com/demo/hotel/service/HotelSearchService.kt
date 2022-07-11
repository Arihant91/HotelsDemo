package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.domain.PriceDetails
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.convertValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class HotelSearchService {

    @Autowired
    lateinit var availabilityService: AvailabilityService

    @Autowired
    lateinit var priceService: PriceService

    @Autowired
    lateinit var hotelCardService: HotelCardService

    fun getListOfHotelCardDetails(
        location: String,
        checkInDate: String,
        checkOutDate: String
    ): List<HotelCardDetails>? {

        val listOfIds: MutableList<Int> =
            availabilityService.getAvailableHotelIds(
                location,
                checkInDate,
                checkOutDate
            )

        val listOfPriceDetails: MutableList<PriceDetails> =
            priceService.getPrices(listOfIds)

        val listOfHotelStaticCardDetails: MutableList<HotelCardDetails> =
            hotelCardService.getListOfHotelCardDetails(listOfIds)

        return  addPriceDetailsToHotelCards(listOfHotelStaticCardDetails, listOfPriceDetails)
    }

    fun getListOfHotelCardDetailsAsync(location: String,
                                  checkInDate: String,
                                  checkOutDate: String
    ): List<HotelCardDetails>? {
        val listOfIds: MutableList<Int> =
            availabilityService.getAvailableHotelIds(
                location,
                checkInDate,
                checkOutDate
            )

        val listOfPriceDetails: Mono<MutableList<PriceDetails>> =
            priceService.getPricesAsync(listOfIds)

        listOfPriceDetails.subscribe{ println(it)}

        val listOfHotelStaticCardDetails: MutableList<HotelCardDetails> =
            hotelCardService.getListOfHotelCardDetailsAsync(listOfIds).block()!!

        return addPriceDetailsToHotelCards(listOfHotelStaticCardDetails, null)
    }
    fun endOfAsync(){
        println("dickbutt")
    }


    private fun addPriceDetailsToHotelCards(
        listOfHotelStaticCardDetails: MutableList<HotelCardDetails>?,
        listOfPriceDetails: MutableList<PriceDetails>?
    ): MutableList<HotelCardDetails> {

        val listOfHotelCardDetails: MutableList<HotelCardDetails> =
            mutableListOf()
        val objectMapper: ObjectMapper = ObjectMapper()
        val listOfHotelStaticCardDetailsConverted: MutableList<HotelCardDetails> =
            objectMapper.convertValue<MutableList<HotelCardDetails>>(
                listOfHotelStaticCardDetails!!
            )
        val listOfPriceDetailsConverted: MutableList<PriceDetails> =
            objectMapper.convertValue<MutableList<PriceDetails>>(
                listOfPriceDetails!!
            )
        for (i in 0 until listOfHotelStaticCardDetails!!.size) {
            if (listOfHotelStaticCardDetailsConverted != null && listOfPriceDetails != null) {
                listOfHotelCardDetails.add(
                    HotelCardDetails(
                        listOfHotelStaticCardDetailsConverted[i].id,
                        listOfHotelStaticCardDetailsConverted[i].hotelName,
                        listOfHotelStaticCardDetailsConverted[i].location,
                        listOfHotelStaticCardDetailsConverted[i].amenities,
                        listOfHotelStaticCardDetailsConverted[i].description,
                        listOfHotelStaticCardDetailsConverted[i].rating,
                        PriceDetails(
                            listOfPriceDetailsConverted[i].id,
                            listOfPriceDetailsConverted[i].nightly,
                            listOfPriceDetailsConverted[i].total
                        )
                    )
                )
            }
        }
        println(listOfHotelCardDetails)
        return listOfHotelCardDetails

    }
}