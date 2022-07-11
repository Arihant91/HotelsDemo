package com.demo.pricedisplay.domain

import com.demo.pricedisplay.model.PriceDetails
import org.springframework.stereotype.Component

@Component
class PriceDetailsConverter {

    fun converter(priceDetails: PriceDetails): WebPriceDetails{
        return WebPriceDetails(priceDetails.id, priceDetails.nightly, priceDetails.total)
    }
}