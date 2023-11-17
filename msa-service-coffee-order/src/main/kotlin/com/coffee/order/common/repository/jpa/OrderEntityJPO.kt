package com.coffee.order.common.repository.jpa

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class OrderEntityJPO (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: String? = null,
    val orderNumber: String?,
    val coffeeName: String?,
    val coffeeCount: String?,
    val customerName: String?,
)