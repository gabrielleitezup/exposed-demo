package com.example.exposeddemo.data.entity

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.LocalDateTime
import java.sql.Timestamp
import java.util.Date
import java.util.UUID

data class SquadMembers(
    val id: Long,
    val squad: Long,
    val customerDetail: UUID,
    val isLeader:Boolean,
    val isTech:Boolean,
    val status: String,
    val createAt: Date,
    val inactivateAt: Date?
)

data class SquadMembersWithCustomer(
    val id: Long,
    val squad: Long,
    val customerDetail: CustomerDetail,
    val isLeader:Boolean,
    val isTech:Boolean,
    val status: String,
    val createAt: Date,
    val inactivateAt: Date?
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