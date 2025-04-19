package com.example.taskfourkfd.repository.model.view

import com.example.taskfourkfd.repository.model.Capital
import com.example.taskfourkfd.repository.model.Currency
import com.example.taskfourkfd.repository.model.Users
import java.util.UUID

data class ViewCapital(
    var id: Long = 0L,
    val user_id: UUID,
    val currency: String,
    val amount: Long
) {
    fun toCapital(user: Users, currency: Currency): Capital =
        Capital(
            user = user,
            currency = currency,
            amount = amount
        )
    fun toCapital(id: Long, user: Users, currency: Currency) =
        Capital(
            id = id,
            user = user,
            currency = currency,
            amount = amount
        )
}