package com.example.exposeddemo.controller

import com.example.exposeddemo.data.entity.Squad
import com.example.exposeddemo.service.SquadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SquadController(
    private val squadService: SquadService
) {

    @GetMapping("/squad")
    @ResponseBody
    fun findAll(): List<Squad> {
        return squadService.findAll()
    }
}