package com.example.exposeddemo.service

import com.example.exposeddemo.data.entity.Squad
import com.example.exposeddemo.data.repository.SquadRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SquadService(
    private val squadRepository: SquadRepository
) {

    fun findAll(): List<Squad> {
        return squadRepository.findAll()
    }

}