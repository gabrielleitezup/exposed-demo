package com.example.exposeddemo.controller

import com.example.exposeddemo.data.entity.CustomerDetail
import com.example.exposeddemo.service.CustomerDetailService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerDetailController(
    private val customerDetailService: CustomerDetailService
) {

    @GetMapping("/customers")
    @ResponseBody
    fun findAll():List<CustomerDetail> {
        return customerDetailService.findAll()
    }

}