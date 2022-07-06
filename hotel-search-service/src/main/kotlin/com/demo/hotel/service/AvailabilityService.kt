package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import java.nio.charset.StandardCharsets

@Service
class AvailabilityService {

    fun getAvailableHotelIds(location: String, checkIn: String, checkOut: String): MutableList<Int>? {

        val hMap: MultiValueMap<String, String> =
            LinkedMultiValueMap()
        hMap.add("location", location)
        hMap.add("checkInDate", checkIn)
        hMap.add("checkOutDate", checkOut)

        val uriComponentsBuilder: UriComponentsBuilder =
            UriComponentsBuilder.newInstance().scheme("http")
                .host("localhost").port("50050")
                .path("/seachByTime")
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

        var response =
            client.retrieve().toEntity(mutableListOf<Int>().javaClass).block()!!.body

        return response
    }


}