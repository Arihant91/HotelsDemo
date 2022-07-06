package com.demo.pricedisplay.web

import com.demo.pricedisplay.domain.WebPriceDetails
import com.demo.pricedisplay.model.PriceDetails
import com.demo.pricedisplay.service.PriceDisplayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class GetPriceController {

    @Autowired
    lateinit var priceDisplayService: PriceDisplayService

    @GetMapping("/getPrices")
    fun getPrice(@RequestParam("ids") ids: List<Int> ): List<WebPriceDetails>{
        return priceDisplayService.getPriceDetails(ids)
    }

    @GetMapping("/save")
    fun save(): String{
        return priceDisplayService.save()
    }

    @GetMapping("/returnAll")
    fun getData(): Iterable<PriceDetails>{
        return priceDisplayService.getData()
    }
}