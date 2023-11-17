package com.coffee.status.common.model

import com.coffee.status.common.repository.dvo.OrderStatusDVO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CoffeeOrderStatus(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    @Column(length = 300)
    var orderHistory: String?,
) {
    fun toDvo(): OrderStatusDVO {
        return OrderStatusDVO(this.id, this.orderHistory)
    }
}