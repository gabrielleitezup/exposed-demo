package com.example.exposeddemo.data.repository

import com.example.exposeddemo.data.entity.User
import com.example.exposeddemo.data.entity.UserTable
import com.example.exposeddemo.data.utils.toUser
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class UserRepository {

    fun findUserByName(name: String): List<User> =
        transaction {
            UserTable.select { UserTable.username eq name }.map { it.toUser() }
        }

    fun findAll(): List<User> =
        transaction {
            UserTable.selectAll().map { it.toUser() }
        }

}
