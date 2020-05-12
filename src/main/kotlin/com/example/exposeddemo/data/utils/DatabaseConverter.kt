package com.example.exposeddemo.data.utils

import com.example.exposeddemo.data.entity.CustomerDetail
import com.example.exposeddemo.data.entity.CustomerDetailTable
import com.example.exposeddemo.data.entity.Squad
import com.example.exposeddemo.data.entity.SquadMembers
import com.example.exposeddemo.data.entity.SquadMembersTable
import com.example.exposeddemo.data.entity.SquadMembersWithCustomer
import com.example.exposeddemo.data.entity.SquadTable
import com.example.exposeddemo.data.entity.User
import com.example.exposeddemo.data.entity.UserTable
import org.jetbrains.exposed.sql.ResultRow

internal fun ResultRow.toUser(): User =
    User(
        username = this[UserTable.username],
        password = this[UserTable.password],
        email = this[UserTable.email]
    )

internal fun ResultRow.toCustomerDetail(): CustomerDetail =
    CustomerDetail(
        name = this[CustomerDetailTable.name],
        email = this[CustomerDetailTable.email],
        gender = this[CustomerDetailTable.gender],
        birthDate = this[CustomerDetailTable.birthDate].toDate(),
        subsidiary = this[CustomerDetailTable.subsidiary],
        status = this[CustomerDetailTable.status],
        documentType = this[CustomerDetailTable.documentType],
        documentValue = this[CustomerDetailTable.documentValue],
        registry = this[CustomerDetailTable.registry],
        startDate = this[CustomerDetailTable.startDate].toDate(),
        endDate = this[CustomerDetailTable.endDate]?.toDate(),
        occupationName = this[CustomerDetailTable.occupationName],
        salary = this[CustomerDetailTable.salary],
        phoneNumber = this[CustomerDetailTable.phoneNumber]
    )

internal fun ResultRow.toSquad(): Squad =
    Squad(
        name = this[SquadTable.name],
        status = this[SquadTable.status]
    )

internal fun ResultRow.toSquadMembers(): SquadMembers =
    SquadMembers(
        id = this[SquadMembersTable.id].value,
        squad = this[SquadMembersTable.squad],
        customerDetail = this[SquadMembersTable.customerDetail],
        isLeader = this[SquadMembersTable.isLeader],
        isTech = this[SquadMembersTable.isTech],
        status = this[SquadMembersTable.status],
        createAt = this[SquadMembersTable.createAt].toDate(),
        inactivateAt = this[SquadMembersTable.inactivateAt]?.toDate()
    )

internal fun ResultRow.toSquadMembersWithCustomer(): SquadMembersWithCustomer =
    SquadMembersWithCustomer(
        id = this[SquadMembersTable.id].value,
        squad = this[SquadMembersTable.squad],
        customerDetail = this[SquadMembersTable.customerDetail]?.let { this.toCustomerDetail() },
        isLeader = this[SquadMembersTable.isLeader],
        isTech = this[SquadMembersTable.isTech],
        status = this[SquadMembersTable.status],
        createAt = this[SquadMembersTable.createAt].toDate(),
        inactivateAt = this[SquadMembersTable.inactivateAt]?.toDate()
    )