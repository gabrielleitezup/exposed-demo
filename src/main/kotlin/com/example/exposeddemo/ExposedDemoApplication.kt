package com.example.exposeddemo

import com.example.exposeddemo.repository.UserTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExposedDemoApplication

fun main(args: Array<String>) {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/exposed",
        driver = "org.postgresql.Driver",
        user = "user_db", password = "user_db"
    )
    transaction {
        SchemaUtils.create(UserTable)
    }
    runApplication<ExposedDemoApplication>(*args)
}
