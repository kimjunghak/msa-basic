package com.coffee.order.common.repository

import com.coffee.order.common.repository.jpa.ICoffeeOrderJpaRepository
import com.coffee.order.common.repository.jpa.OrderEntityJPO
import com.coffee.order.domain.model.OrderEntity
import com.coffee.order.domain.repository.ICoffeeOrderRepository
import org.springframework.stereotype.Repository

@Repository
class CoffeeOrderRepository(
    private val iCoffeeOrderJpaRepository: ICoffeeOrderJpaRepository
): ICoffeeOrderRepository {

    override fun coffeeOrderSave(orderEntity: OrderEntity): String? {
        val orderEntityJPO = OrderEntityJPO(
            null,
            orderEntity.orderNumber,
            orderEntity.coffeeName,
            orderEntity.coffeeCount,
            orderEntity.customerName,
        )
        iCoffeeOrderJpaRepository.save(orderEntityJPO)

        return orderEntityJPO.id
    }
}