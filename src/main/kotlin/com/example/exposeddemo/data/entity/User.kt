package com.example.exposeddemo.data.entity

import org.jetbrains.exposed.dao.id.IntIdTable

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