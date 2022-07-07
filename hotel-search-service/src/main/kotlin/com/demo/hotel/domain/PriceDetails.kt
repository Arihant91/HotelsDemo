package com.demo.hotel.domain

data class PriceDetails(val id: Int = 0 ,val nightly: Double = 1.0, val total: Double = nightly * 1.25) {
}