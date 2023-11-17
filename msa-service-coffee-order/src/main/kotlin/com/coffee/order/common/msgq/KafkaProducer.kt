package com.coffee.order.common.msgq

import com.coffee.order.domain.model.CoffeeOrderCVO
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val objectMapper: ObjectMapper,
) {

    fun send(kafkaTopic: String, coffeeOrderCVO: CoffeeOrderCVO): CoffeeOrderCVO {
        var jsonInString = ""

        try {
            jsonInString = objectMapper.writeValueAsString(coffeeOrderCVO)
        } catch (ex: JsonProcessingException) {
            ex.printStackTrace()
        }

        kafkaTemplate.send(kafkaTopic, jsonInString)

        println("KafkaProducer send data from msa-service-coffee-order: $coffeeOrderCVO")

        return coffeeOrderCVO
    }
}