package org.example.paymentservice.user_service

import java.util.UUID

data class Users (
    val uid: UUID,
    val login: String,
    var password: String,
    val role: String
)