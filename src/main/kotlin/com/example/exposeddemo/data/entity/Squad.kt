package com.example.exposeddemo.data.entity

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.jodatime.datetime


data class Squad(
    var name: String,
    val status: String
)

object SquadTable : LongIdTable("squad") {
    val name = text("name")
    val status = text("status")
    val createAt = datetime("create_at")
    val inactivateAt = datetime("inactivate_at")
}
