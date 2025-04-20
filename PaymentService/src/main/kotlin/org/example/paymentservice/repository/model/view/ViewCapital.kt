package org.example.paymentservice.repository.model.view

import org.example.paymentservice.repository.model.Capital
import org.example.paymentservice.repository.model.Currency
import org.example.paymentservice.user_service.Users
import java.util.UUID

data class ViewCapital(
    var id: Long = 0L,
    val user_id: UUID,
    val currency: String,
    val amount: Long
) {
    fun toCapital(user: Users, currency: Currency): Capital =
        Capital(
            user = user.uid,
            currency = currency,
            amount = amount
        )
    fun toCapital(id: Long, user: Users, currency: Currency) =
        Capital(
            id = id,
            user = user.uid,
            currency = currency,
            amount = amount
        )
}