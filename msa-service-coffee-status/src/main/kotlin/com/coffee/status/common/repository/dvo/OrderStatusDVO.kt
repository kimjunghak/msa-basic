package com.coffee.status.common.repository.dvo

import com.coffee.status.common.model.CoffeeOrderStatus
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class OrderStatusDVO(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val orderHistory: String?,
) {
    fun toEntity(): CoffeeOrderStatus {
        return CoffeeOrderStatus(this.id, this.orderHistory)
    }
}
