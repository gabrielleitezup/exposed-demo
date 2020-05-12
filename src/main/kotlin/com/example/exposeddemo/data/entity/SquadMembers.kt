package com.example.exposeddemo.data.entity

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.jodatime.datetime
import java.math.BigInteger
import java.sql.Timestamp

data class SquadMembers(
    val id: Long,
    val squad: BigInteger,
    val customerDetail: String,
    val isLeader:Boolean,
    val isTech:Boolean,
    val status: String,
    val createAt: Timestamp,
    val inactivateAt: Timestamp?
)

object SquadMembersTable : LongIdTable("squad_members") {
    val squad = long("squad_id").references(SquadTable.id)
    val customerDetail = uuid("customer_detail_id").references(CustomerDetailTable.id)
    val isLeader = bool("is_leader")
    val isTech = bool("is_tech")
    val status = text("status")
    val createAt = datetime("create_at")
    val inactivateAt = datetime("inactivate_at")
}