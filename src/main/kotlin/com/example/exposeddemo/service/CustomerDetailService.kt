package com.example.exposeddemo.service

import com.example.exposeddemo.data.entity.CustomerDetail
import com.example.exposeddemo.data.repository.CustomerDetailRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CustomerDetailService(
    private val customerDetailRepository: CustomerDetailRepository
) {
    fun findAll(): List<CustomerDetail> {
        return customerDetailRepository.findAll()
    }
}