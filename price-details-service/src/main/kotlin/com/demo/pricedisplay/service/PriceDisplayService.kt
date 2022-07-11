package com.demo.pricedisplay.service

import com.demo.pricedisplay.domain.PriceDetailsConverter
import com.demo.pricedisplay.domain.WebPriceDetails
import com.demo.pricedisplay.model.PriceDetails
import com.demo.pricedisplay.repository.PriceDetailsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class PriceDisplayService {

    @Autowired
    lateinit var repository: PriceDetailsRepository

    @Autowired
    lateinit var priceDetailsConverter : PriceDetailsConverter

    fun getPriceDetails(ids: List<Int>): MutableList<WebPriceDetails>{
        val listOfPriceDetails: Iterable<PriceDetails> = repository.findAllById(ids)
        val listOfWebPriceDetails : MutableList<WebPriceDetails> = mutableListOf()

        for (priceDetails in  listOfPriceDetails){
            listOfWebPriceDetails.add(priceDetailsConverter.converter(priceDetails))
        }

        return listOfWebPriceDetails
    }

    fun save(): String {
        repository.saveAll(
            listOf(
                PriceDetails(0, 40.0),
                PriceDetails(0, 50.0),
                PriceDetails(0, 60.0),
                PriceDetails(0, 70.0),
                PriceDetails(0, 80.0),
                PriceDetails(0, 90.0),
                PriceDetails(0, 95.0),
            )
        )
        return "Done"
    }

    fun getData(): Iterable<PriceDetails>{
        return  repository.findAll()
    }

}