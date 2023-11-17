package com.coffee.member.common.api

import com.coffee.member.common.repository.ICoffeeMemberRepository
import com.coffee.member.common.repository.dvo.MemberDVO
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.*

@RefreshScope
@RestController
class CoffeeMemberApi(
    private val iCoffeeMemberRepository: ICoffeeMemberRepository,
) {

    @HystrixCommand
    @GetMapping("/coffeeMember/v1.0/{memberName}")
    fun coffeeMember(@PathVariable memberName: String): Boolean {
        return iCoffeeMemberRepository.existsByMemberName(memberName)
    }

    @HystrixCommand
    @PostMapping("/coffeeMember/v1.1")
    fun coffeeMember(@RequestBody memberDVO: MemberDVO): Boolean {
        val memberName = memberDVO.memberName?: throw RuntimeException("error")
        return iCoffeeMemberRepository.existsByMemberName(memberName)
    }

    @HystrixCommand(fallbackMethod = "fallbackFunction")
    @GetMapping("/fallbackTest")
    fun fallbackTest(): String {
        throw Throwable("fallbackTest")
    }

    fun fallbackFunction(): String {
        return "fallbackFunction()"
    }

}