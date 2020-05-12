package com.example.exposeddemo.data.repository

import com.example.exposeddemo.data.entity.CustomerDetail
import com.example.exposeddemo.data.entity.CustomerDetailTable
import com.example.exposeddemo.data.utils.toCustomerDetail
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class CustomerDetailRepository{

    fun findAll(): List<CustomerDetail> =
        transaction {
            CustomerDetailTable.selectAll().map { it.toCustomerDetail() }
        }
}