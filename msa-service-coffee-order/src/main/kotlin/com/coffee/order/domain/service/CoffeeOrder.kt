package com.coffee.order.domain.service

import com.coffee.order.domain.model.CoffeeOrderCVO
import com.coffee.order.domain.model.OrderEntity
import com.coffee.order.domain.repository.ICoffeeOrderRepository

open class CoffeeOrder(
    private val iCoffeeOrderRepository: ICoffeeOrderRepository,
): ICoffeeOrder {

    override fun coffeeOrder(coffeeOrderCVO: CoffeeOrderCVO): String? {
        val orderEntity = OrderEntity(
            coffeeOrderCVO.id,
            coffeeOrderCVO.orderNumber,
            coffeeOrderCVO.coffeeName,
            coffeeOrderCVO.coffeeCount,
            coffeeOrderCVO.customerName,
        )

        iCoffeeOrderRepository.coffeeOrderSave(orderEntity)

        return orderEntity.id
    }
}