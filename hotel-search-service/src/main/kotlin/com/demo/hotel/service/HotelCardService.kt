package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import com.demo.hotel.domain.PriceDetails
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import java.nio.charset.StandardCharsets


class HotelCardService {

    fun getListOfHotelCardDetails(
        location: String,
        checkInDate: String,
        checkOutDate: String
    ): List<HotelCardDetails> {

        val client = WebClient.create().get()
            .uri("localhost:50051/getListOfHotelsDescriptions")
            .header(
                HttpHeaders.CONTENT_TYPE,
                MediaType.APPLICATION_JSON_VALUE
            ).accept(MediaType.APPLICATION_JSON).acceptCharset(
                StandardCharsets.UTF_8
            )

        val hMap: MultiValueMap<String, String> = LinkedMultiValueMap()
        hMap.add("location", location)
        hMap.add("checkInDate", checkInDate)
        hMap.add("checkOutDate", checkOutDate)
        val uriComponentsBuilder: UriComponentsBuilder =
            UriComponentsBuilder.newInstance().scheme("http").host("localhost").port("50051").queryParams(hMap)

        return listOf(
            HotelCardDetails(
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