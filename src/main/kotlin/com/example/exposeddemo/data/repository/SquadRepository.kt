package com.example.exposeddemo.data.repository

import com.example.exposeddemo.data.entity.Squad
import com.example.exposeddemo.data.entity.SquadTable
import com.example.exposeddemo.data.utils.toSquad
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class SquadRepository {

    fun findAll(): List<Squad> =
        transaction {
            SquadTable.selectAll().map { it.toSquad() }
        }

}