package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.domain.PriceDetails
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import java.nio.charset.StandardCharsets


class HotelCardService {

    suspend fun getListOfHotelCardDetails(
        location: String,
        checkInDate: String,
        checkOutDate: String
    ): List<HotelCardDetails> {

        val hMap: MultiValueMap<String, String> =
            LinkedMultiValueMap()
        hMap.add("location", location)
        hMap.add("checkInDate", checkInDate)
        hMap.add("checkOutDate", checkOutDate)
        val uriComponentsBuilder: UriComponentsBuilder =
            UriComponentsBuilder.newInstance().scheme("http")
                .host("localhost").port("50051")
                .path("/getListOfHotelsDescriptions")
                .queryParams(hMap)
        val uri: UriComponents = uriComponentsBuilder.build()

        val client = WebClient.create().get()
            .uri(uri.toUri())
            .header(
                HttpHeaders.CONTENT_TYPE,
                MediaType.APPLICATION_JSON_VALUE
            ).accept(MediaType.APPLICATION_JSON).acceptCharset(
                StandardCharsets.UTF_8
            )
        println(uri.toUri())

        var response =
            client.retrieve().toEntity(HotelCardDetails().javaClass).block()

//        var response = client.retrieve().awaitBody<HotelCardDetails.>()

        if (response != null) {
            println(response.body?.hotelName)
        }

        return listOf(
            HotelCardDetails(0,
                "budapestHotel",
                "Budapest",
                listOf("football"),
                "nice place",
                5,
                PriceDetails(500, 600)
            )
        )
    }
}