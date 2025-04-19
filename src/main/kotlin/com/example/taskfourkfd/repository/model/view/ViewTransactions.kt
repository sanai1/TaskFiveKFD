package com.example.taskfourkfd.repository.model.view

import com.example.taskfourkfd.repository.model.Currency
import com.example.taskfourkfd.repository.model.Transactions
import com.example.taskfourkfd.repository.model.Users
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
            user = user,
            currencyOne = currencyOne,
            currencyTwo = currencyTwo,
            course = course,
            summaOne = summa_one,
            summaTwo = summa_two
        )
}