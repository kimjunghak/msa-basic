package com.coffee.status.common.msgq

import com.coffee.status.common.repository.ICoffeeStatusRepository
import com.coffee.status.common.repository.dvo.OrderStatusDVO
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer(
    private val iCoffeeStatusRepository: ICoffeeStatusRepository,
) {

    @KafkaListener(topics = ["kafka-test"])
    fun processMessages(kafkaMessage: String) {
        println("kafkaMessage: ======> $kafkaMessage")

        val orderStatusDVO = OrderStatusDVO(orderHistory = kafkaMessage)

        iCoffeeStatusRepository.save(orderStatusDVO.toEntity())
    }
}