package com.coffee.member.common.repository

import com.coffee.member.common.model.Member

interface ICoffeeMemberRepository: BaseRepository<Member, Int> {

    fun existsByMemberName(memberName: String): Boolean
}