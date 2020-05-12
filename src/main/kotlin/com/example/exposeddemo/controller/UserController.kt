package com.example.exposeddemo.controller

import com.example.exposeddemo.data.entity.User
import com.example.exposeddemo.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {

    @GetMapping("/user/{name}")
    @ResponseBody
    fun findUserByName(@PathVariable name: String): List<User> {
        return userService.findUserByName(name)
    }

    @GetMapping("/user")
    @ResponseBody
    fun findAllUsers(): List<User> {
        return userService.findAllUsers()
    }
}