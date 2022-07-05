package com.demo.pricedisplay.web

import com.demo.pricedisplay.service.PriceDisplayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class GetPriceController {

    @Autowired
    lateinit var priceDisplayService: PriceDisplayService

    @GetMapping("/price")
    fun getPrice(@RequestParam("id") location: String): String{
        return "15"
    }
}