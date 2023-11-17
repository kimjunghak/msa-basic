package com.coffee.order.common.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("msa-service-coffee-member")
interface IMsaServiceCoffeeMember {

    @GetMapping("/coffeeMember/v1.0/{memberName}")
    fun coffeeMember(@PathVariable memberName: String): Boolean
}