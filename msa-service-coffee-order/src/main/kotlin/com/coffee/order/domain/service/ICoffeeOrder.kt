package com.coffee.order.domain.service

import com.coffee.order.domain.model.CoffeeOrderCVO

interface ICoffeeOrder {

    fun coffeeOrder(coffeeOrderCVO: CoffeeOrderCVO): String?
}