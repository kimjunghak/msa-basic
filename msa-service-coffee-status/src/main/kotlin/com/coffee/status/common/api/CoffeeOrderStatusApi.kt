package com.coffee.status.common.api

import com.coffee.status.common.repository.ICoffeeStatusRepository
import com.coffee.status.common.repository.dvo.OrderStatusDVO
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CoffeeOrderStatusApi(
    private val iCoffeeStatusRepository: ICoffeeStatusRepository,
) {

    @HystrixCommand
    @PostMapping("/coffeeOrderStatus")
    fun coffeeOrderStatus(): ResponseEntity<List<OrderStatusDVO>> {
        val allStatus = iCoffeeStatusRepository.findAll().map { it.toDvo() }
        return ResponseEntity.ok(allStatus)
    }
}