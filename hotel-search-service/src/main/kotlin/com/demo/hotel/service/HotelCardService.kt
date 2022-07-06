package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.domain.PriceDetails
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
    ): MutableList<HotelCardDetails>? {

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

        var response =
            client.retrieve()
                .toEntity(mutableListOf<HotelCardDetails>().javaClass).block()!!.body


        return response
    }
}