package com.example.taskfourkfd.service

import com.example.taskfourkfd.repository.dao.CapitalDao
import com.example.taskfourkfd.repository.dao.CurrencyDao
import com.example.taskfourkfd.repository.dao.UsersDao
import com.example.taskfourkfd.repository.model.Capital
import com.example.taskfourkfd.repository.model.view.ViewCapital
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CapitalService (
    private val capitalDao: CapitalDao,
    private val currencyDao: CurrencyDao,
    private val usersDao: UsersDao
) {
    fun getCapital(userId: UUID): List<ViewCapital> {
        val user = usersDao.findByIdOrNull(userId)
        return if (user != null) {
            val listViewCapital = emptyList<ViewCapital>().toMutableList()
            capitalDao.findByUser(user).forEach { listViewCapital.add(it.fromCapital()) }
            listViewCapital
        } else emptyList()
    }

    private fun createCapital(capital: Capital): Capital = capitalDao.save(capital)

    fun createListCapital(userId: UUID, listViewCapital: List<ViewCapital>): List<ViewCapital> {
        val user = usersDao.findByIdOrNull(userId)
        return if (user != null) {
            listViewCapital.map {
                val currency = currencyDao.findByIdOrNull(it.currency)
                if (currency != null) {
                    val capital = createCapital(it.toCapital(user, currency))
                    it.id = capital.id
                }
            }
            listViewCapital
        } else emptyList()
    }

    fun updateCapital(userId: UUID, capitalId: Long, viewCapital: ViewCapital): ViewCapital? {
        viewCapital.id = capitalId
        val user = usersDao.findByIdOrNull(userId)
        val currency = currencyDao.findByIdOrNull(viewCapital.currency)
        return if (user != null && currency != null) {
            val capital = capitalDao.save(viewCapital.toCapital(viewCapital.id, user, currency))
            viewCapital
        } else null
    }

}