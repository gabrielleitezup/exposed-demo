package com.example.exposeddemo.data.repository

import com.example.exposeddemo.data.entity.CustomerDetailTable
import com.example.exposeddemo.data.entity.SquadMembers
import com.example.exposeddemo.data.entity.SquadMembersTable
import com.example.exposeddemo.data.entity.SquadMembersWithCustomer
import com.example.exposeddemo.data.utils.toSquadMembers
import com.example.exposeddemo.data.utils.toSquadMembersWithCustomer
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class SquadMembersRepository{

    private val squadMemberWithCostumer = SquadMembersTable innerJoin CustomerDetailTable

    fun findAll():List<SquadMembers> =
        transaction {
            SquadMembersTable.selectAll().map { it.toSquadMembers() }
        }

    fun findAllWithCustomer() :List<SquadMembersWithCustomer> =
        transaction {
            squadMemberWithCostumer.selectAll().map { it.toSquadMembersWithCustomer() }
        }

}