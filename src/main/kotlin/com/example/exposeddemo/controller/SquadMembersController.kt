package com.example.exposeddemo.controller

import com.example.exposeddemo.data.entity.SquadMembers
import com.example.exposeddemo.data.entity.SquadMembersWithCustomer
import com.example.exposeddemo.service.SquadMembersService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SquadMembersController (
    private val squadMembersService: SquadMembersService
){
    @GetMapping("/members")
    @ResponseBody
    fun findAll(): List<SquadMembers> {
        return squadMembersService.findAll()
    }

    @GetMapping("/members-customer")
    @ResponseBody
    fun findAllWithCustomer(): List<SquadMembersWithCustomer> {
        return squadMembersService.findAllWithCustomer()
    }
}