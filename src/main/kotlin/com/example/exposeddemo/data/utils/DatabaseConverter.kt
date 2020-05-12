package com.example.exposeddemo.data.utils

import com.example.exposeddemo.data.entity.CustomerDetail
import com.example.exposeddemo.data.entity.CustomerDetailTable
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