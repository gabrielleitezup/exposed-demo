package com.example.exposeddemo.controller

import com.example.exposeddemo.repository.User
import com.example.exposeddemo.service.FakeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val fakeService: FakeService
) {

    @GetMapping("/user")
    @ResponseBody
    fun findUser(): List<User> {
        return fakeService.findUser()
    }
}