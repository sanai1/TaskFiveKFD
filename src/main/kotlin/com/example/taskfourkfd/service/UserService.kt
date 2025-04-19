package com.example.taskfourkfd.service

import com.example.taskfourkfd.repository.dao.CurrencyDao
import com.example.taskfourkfd.repository.dao.TransactionsDao
import com.example.taskfourkfd.repository.dao.UsersDao
import com.example.taskfourkfd.repository.model.Users
import com.example.taskfourkfd.repository.model.view.ViewTransactions
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService (
    private val usersDao: UsersDao,
    private val transactionsDao: TransactionsDao,
    private val currencyDao: CurrencyDao
) {

    fun findAllUsers(): List<Users> = usersDao.findAll()

    fun getUserById(userId: UUID): Users? = usersDao.findByIdOrNull(userId)

    fun createUser(user: Users): Users {
        user.password = getEncoder().encode(user.password)
        return usersDao.save(user)
    }

    fun createTransaction(viewTransactions: ViewTransactions): ViewTransactions? {
        val user = usersDao.findByIdOrNull(viewTransactions.user_uid)
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
        val user = usersDao.findById(userId).orElse(null)
        return if (user != null) {
            val listPseudoTransactions: MutableList<ViewTransactions> = emptyList<ViewTransactions>().toMutableList()
            transactionsDao.findByUser(user).forEach { listPseudoTransactions.add(it.fromTransaction()) }
            listPseudoTransactions
        } else emptyList()
    }

    private fun getEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}