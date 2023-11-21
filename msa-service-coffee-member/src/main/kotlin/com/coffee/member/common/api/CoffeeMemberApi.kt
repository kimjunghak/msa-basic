package com.coffee.member.common.api

import com.coffee.member.common.model.Member
import com.coffee.member.common.repository.ICoffeeMemberRepository
import com.coffee.member.common.repository.dvo.MemberDVO
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.*

@RefreshScope
@RestController
class CoffeeMemberApi(
    private val iCoffeeMemberRepository: ICoffeeMemberRepository,
) {

    @GetMapping("/coffeeMember/v1.0/{memberName}")
    fun coffeeMember(@PathVariable memberName: String): Boolean {
        return iCoffeeMemberRepository.existsByMemberName(memberName)
    }

    @PostMapping("/coffeeMember/v1.1")
    fun coffeeMember(@RequestBody memberDVO: MemberDVO): Boolean {
        val memberName = memberDVO.memberName?: throw RuntimeException("error")
        return iCoffeeMemberRepository.existsByMemberName(memberName)
    }

    @PutMapping("/createMember")
    fun createMember(@RequestBody memberDVO: MemberDVO): Boolean {
        return iCoffeeMemberRepository.save(Member(memberName = memberDVO.memberName)).id != null
    }

}