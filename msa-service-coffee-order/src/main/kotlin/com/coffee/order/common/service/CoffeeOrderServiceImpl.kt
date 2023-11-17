package com.coffee.order.common.service

import com.coffee.order.domain.repository.ICoffeeOrderRepository
import com.coffee.order.domain.service.CoffeeOrder
import org.springframework.stereotype.Service

@Service
class CoffeeOrderServiceImpl(
    private val iCoffeeOrderRepository: ICoffeeOrderRepository
): CoffeeOrder(iCoffeeOrderRepository)