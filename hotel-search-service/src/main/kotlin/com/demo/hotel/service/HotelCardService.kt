package com.demo.hotel.service

import com.demo.hotel.domain.HotelCardDetails
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.nio.charset.StandardCharsets

@Service
class HotelCardService {


    fun getListOfHotelCardDetails(listOfIds: MutableList<Int>?): MutableList<HotelCardDetails> {


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


        return client.retrieve()
            .toEntity(mutableListOf<HotelCardDetails>().javaClass)
            .block()!!.body!!
    }

    fun getListOfHotelCardDetailsAsync(listOfIds: MutableList<Int>): Mono<MutableList<HotelCardDetails>> {

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

        return client.retrieve().bodyToMono(mutableListOf<HotelCardDetails>().javaClass)!!
    }


}
