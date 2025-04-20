package org.example.paymentservice.service

import org.example.paymentservice.repository.dao.CapitalDao
import org.example.paymentservice.repository.dao.CurrencyDao
import org.example.paymentservice.repository.model.Capital
import org.example.paymentservice.repository.model.view.ViewCapital
import org.example.paymentservice.user_service.UserServiceClient
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CapitalService (
    private val capitalDao: CapitalDao,
    private val currencyDao: CurrencyDao,
    private val userServiceClient: UserServiceClient
) {
    fun getCapital(userId: UUID): List<ViewCapital> {
        val user = userServiceClient.getUserById(userId)
        return if (user != null) {
            val listViewCapital = emptyList<ViewCapital>().toMutableList()
            capitalDao.findByUser(user.uid).forEach { listViewCapital.add(it.fromCapital()) }
            listViewCapital
        } else emptyList()
    }

    private fun createCapital(capital: Capital): Capital = capitalDao.save(capital)

    fun createListCapital(userId: UUID, listViewCapital: List<ViewCapital>): List<ViewCapital> {
        val user = userServiceClient.getUserById(userId)
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
        val user = userServiceClient.getUserById(userId)
        val currency = currencyDao.findByIdOrNull(viewCapital.currency)
        return if (user != null && currency != null) {
            val capital = capitalDao.save(viewCapital.toCapital(viewCapital.id, user, currency))
            viewCapital
        } else null
    }

}