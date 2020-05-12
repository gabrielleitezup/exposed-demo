package com.example.exposeddemo.data.entity

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.jodatime.date
import java.math.BigDecimal
import java.util.Date

data class CustomerDetail(
    val name: String,
    val email: String,
    val gender: String,
    val birthDate: Date,
    val subsidiary: String,
    val status: String,
    val documentType: String,
    val documentValue: String,
    val registry: String,
    val startDate: Date,
    val endDate: Date?,
    val occupationName: String,
    val salary: BigDecimal,
    val phoneNumber: String
)

object CustomerDetailTable : UUIDTable("customer_detail") {
    val name = text("name")
    val email = text("email")
    val gender = text("gender")
    val birthDate = date("birth_date")
    val subsidiary = text("subsidiary")
    val status = text("status")
    val documentType = text("document_type")
    val documentValue = text("document_value")
    val registry = text("registry")
    val startDate = date("start_date")
    val endDate = date("end_date")
    val occupationName = text("occupation_name")
    val salary = decimal("salary", 4, 4)
    val phoneNumber = text("phone_number")
}