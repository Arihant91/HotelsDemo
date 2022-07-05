package com.demo.pricedisplay

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PriceDisplayServiceApplication

fun main(args: Array<String>) {
	runApplication<PriceDisplayServiceApplication>(*args)
}
