package com.demo.pricedisplay.repository

import com.demo.pricedisplay.model.PriceDetails
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PriceDetailsRepository: CrudRepository<PriceDetails, Int> {
}