package com.demo.pricedisplay.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class PriceDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val nightly: Double = 5.5,
    val total: Double = nightly * 1.25
) {



}