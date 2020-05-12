package com.example.exposeddemo.service

import com.example.exposeddemo.data.entity.User
import com.example.exposeddemo.data.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository
) {

    fun findUserByName(name: String): List<User> {
        return userRepository.findUserByName(name)
    }

    fun findAllUsers(): List<User> {
        return userRepository.findAll()
    }

}