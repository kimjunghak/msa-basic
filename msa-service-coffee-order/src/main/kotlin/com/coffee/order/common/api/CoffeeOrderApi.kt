package com.coffee.order.common.api

import com.coffee.order.common.service.CoffeeOrderServiceImpl
import com.coffee.order.common.service.IMsaServiceCoffeeMember
import com.coffee.order.domain.model.CoffeeOrderCVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeOrderApi(
    private val coffeeOrderServiceImpl: CoffeeOrderServiceImpl,
    private val kafkaProducer: com.coffee.order.common.msgq.KafkaProducer,
    private val iMsaServiceCoffeeMember: IMsaServiceCoffeeMember
) {

    @PostMapping("/coffeeOrder")
    fun coffeeOrder(@RequestBody coffeeOrderCVO: CoffeeOrderCVO): ResponseEntity<CoffeeOrderCVO> {
        //is Member
        if (iMsaServiceCoffeeMember.coffeeMember(coffeeOrderCVO.customerName!!)) {
            println("${coffeeOrderCVO.customerName} is a member!")
        }

        //coffee order
        coffeeOrderServiceImpl.coffeeOrder(coffeeOrderCVO)

        //kafka
        kafkaProducer.send("kafka-test", coffeeOrderCVO)

        return ResponseEntity.ok(coffeeOrderCVO)

    }
}