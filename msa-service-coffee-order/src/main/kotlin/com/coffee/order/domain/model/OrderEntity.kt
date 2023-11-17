package com.coffee.order.domain.model

data class OrderEntity(
    val id: String,
    val orderNumber: String?,
    val coffeeName: String?,
    val coffeeCount: String?,
    val customerName: String?,
)