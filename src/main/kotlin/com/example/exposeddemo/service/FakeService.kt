package com.example.exposeddemo.service

import com.example.exposeddemo.repository.TestRepository
import com.example.exposeddemo.repository.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FakeService(
    private val testRepository: TestRepository
) {
    fun findUser(): List<User> {
        val name = "Gabriel"

        return testRepository.findUser(name)
    }



}