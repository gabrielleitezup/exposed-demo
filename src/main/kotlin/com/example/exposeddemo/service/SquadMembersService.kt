package com.example.exposeddemo.service

import com.example.exposeddemo.data.entity.SquadMembers
import com.example.exposeddemo.data.entity.SquadMembersWithCustomer
import com.example.exposeddemo.data.repository.SquadMembersRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SquadMembersService (
    private val squadMembersRepository: SquadMembersRepository
){

    fun findAll(): List<SquadMembers> {
        return squadMembersRepository.findAll()
    }

    fun findAllWithCustomer(): List<SquadMembersWithCustomer> {
        return squadMembersRepository.findAllWithCustomer()
    }
}