package com.coffee.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["com.coffee.order.common.service"])
class MsaServiceCoffeeOrderApplication

fun main(args: Array<String>) {
    runApplication<MsaServiceCoffeeOrderApplication>(*args)
}
