package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.domain.PriceDetails
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.convertValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import java.nio.charset.StandardCharsets

@Service
class HotelCardService {

    @Autowired
    lateinit var availabilityService: AvailabilityService

    @Autowired
    lateinit var priceService: PriceService


    fun getListOfHotelCardDetails(
        location: String,
        checkInDate: String,
        checkOutDate: String
    ): List<HotelCardDetails>? {

        val listOfIds: MutableList<Int>? =
            availabilityService.getAvailableHotelIds(
                location,
                checkInDate,
                checkOutDate
            )

        val listOfPriceDetails: MutableList<PriceDetails>? =
            priceService.getPrices(listOfIds)

        val uriComponentsBuilder: UriComponentsBuilder =
            UriComponentsBuilder.newInstance().scheme("http")
                .host("localhost").port("50051")
                .path("/getHotelDescriptions")
                .queryParam("ids", listOfIds)
        val uri: UriComponents = uriComponentsBuilder.build()

        val client = WebClient.create().get()
            .uri(uri.toUri())
            .header(
                HttpHeaders.CONTENT_TYPE,
                MediaType.APPLICATION_JSON_VALUE
            ).accept(MediaType.APPLICATION_JSON).acceptCharset(
                StandardCharsets.UTF_8
            )

        val listOfHotelStaticCardDetails =
            client.retrieve()
                .toEntity(mutableListOf<HotelCardDetails>().javaClass)
                .block()!!.body

        return addPriceDetailsToHotelCards(
            listOfHotelStaticCardDetails,
            listOfPriceDetails
        )
    }

    private fun addPriceDetailsToHotelCards(
        listOfHotelStaticCardDetails: MutableList<HotelCardDetails>?,
        listOfPriceDetails: MutableList<PriceDetails>?
    ): MutableList<HotelCardDetails> {

        val listOfHotelCardDetails: MutableList<HotelCardDetails> =
            mutableListOf()
        val objectMapper: ObjectMapper =  ObjectMapper()
        val listOfHotelStaticCardDetailsConverted : MutableList<HotelCardDetails> = objectMapper.convertValue<MutableList<HotelCardDetails>>(listOfHotelStaticCardDetails!!)
        val listOfPriceDetailsConverted : MutableList<PriceDetails> = objectMapper.convertValue<MutableList<PriceDetails>>(listOfPriceDetails!!)
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
                        PriceDetails(listOfPriceDetailsConverted[i].id, listOfPriceDetailsConverted[i].nightly, listOfPriceDetailsConverted[i].total)
                    )
                )
            }
        }
        println(listOfHotelCardDetails)
        return listOfHotelCardDetails

    }
}