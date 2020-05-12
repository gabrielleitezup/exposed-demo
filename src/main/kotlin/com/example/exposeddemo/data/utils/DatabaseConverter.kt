package com.example.exposeddemo.data.utils

import com.example.exposeddemo.data.entity.User
import com.example.exposeddemo.data.entity.UserTable
import org.jetbrains.exposed.sql.ResultRow

internal fun ResultRow.toUser(): User =
    User(
        username = this[UserTable.username],
        password = this[UserTable.password],
        email = this[UserTable.email]
    )