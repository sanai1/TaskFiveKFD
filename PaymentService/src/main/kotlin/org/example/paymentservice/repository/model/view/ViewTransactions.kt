package org.example.paymentservice.repository.model.view

import org.example.paymentservice.repository.model.Currency
import org.example.paymentservice.repository.model.Transactions
import org.example.paymentservice.user_service.Users
import java.util.UUID


data class ViewTransactions(
    var id: Long = 0L,
    val user_uid: UUID,
    val currency_one: String,
    val currency_two: String,
    val course: Long,
    val summa_one: Long,
    val summa_two: Long
) {
    fun toTransaction(user: Users, currencyOne: Currency, currencyTwo: Currency): Transactions =
        Transactions(
            user = user.uid,
            currencyOne = currencyOne,
            currencyTwo = currencyTwo,
            course = course,
            summaOne = summa_one,
            summaTwo = summa_two
        )
}