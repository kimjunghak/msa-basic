package com.coffee.order.domain.repository

import com.coffee.order.domain.model.OrderEntity

interface ICoffeeOrderRepository {

    fun coffeeOrderSave(orderEntity: OrderEntity): String?
}