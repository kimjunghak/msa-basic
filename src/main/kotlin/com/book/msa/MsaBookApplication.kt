package com.book.msa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsaBookApplication

fun main(args: Array<String>) {
    runApplication<MsaBookApplication>(*args)
}
