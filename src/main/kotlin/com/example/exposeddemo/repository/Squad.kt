package com.example.exposeddemo.repository

import com.example.exposeddemo.repository.UserTable.email
import com.example.exposeddemo.repository.UserTable.password
import com.example.exposeddemo.repository.UserTable.username
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.datetime
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


data class User(
    val username: String,
    val password: String,
    val email: String
)

object UserTable : IntIdTable() {
    val username = text("username")
    val email = text("email")
    val password = text("password")
}

data class Squad(
    val name: String,
    val status: String
)

object SquadTable : Table() {
    val name = text("name")
    val status = text("status")
    val createAt = datetime("create_at")
}

@Repository
@Transactional
class TestRepository {
    fun findUser(name: String): List<User> =
        transaction {
            UserTable.select { username eq name }.map { it.toUser() }
        }

}

private fun ResultRow.toUser(): User = User(
    username = this[username],
    password = this[password],
    email = this[email]
)
