package org.example.paymentservice.service

import org.example.paymentservice.repository.dao.CurrencyDao
import org.example.paymentservice.repository.dao.TransactionsDao
import org.example.paymentservice.repository.model.view.ViewTransactions
import org.example.paymentservice.user_service.UserServiceClient
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService(
    private val transactionsDao: TransactionsDao,
    private val currencyDao: CurrencyDao,
    private val userServiceClient: UserServiceClient
) {
    fun createTransaction(viewTransactions: ViewTransactions): ViewTransactions? {
        val user = userServiceClient.getUserById(viewTransactions.user_uid)
        val currencyOne = currencyDao.findByIdOrNull(viewTransactions.currency_one)
        val currencyTwo = currencyDao.findByIdOrNull(viewTransactions.currency_two)
        return if (user != null && currencyOne != null && currencyTwo != null) {
            val transaction = transactionsDao.save(
                viewTransactions.toTransaction(user, currencyOne, currencyTwo)
            )
            viewTransactions.id = transaction.id
            viewTransactions
        } else null
    }

    fun getUserTransactions(userId: UUID): List<ViewTransactions> {
        val user = userServiceClient.getUserById(userId)
        return if (user != null) {
            val listPseudoTransactions: MutableList<ViewTransactions> = emptyList<ViewTransactions>().toMutableList()
            transactionsDao.findByUser(user.uid).forEach { listPseudoTransactions.add(it.fromTransaction()) }
            listPseudoTransactions
        } else emptyList()
    }
}
