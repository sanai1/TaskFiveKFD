package com.example.taskfourkfd.service

import com.example.taskfourkfd.repository.dao.CurrencyDao
import com.example.taskfourkfd.repository.model.Currency
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CurrencyService (private val currencyDao: CurrencyDao) {

    fun getAllCurrencies(): List<Currency> = currencyDao.findAll()

    fun getCurrencyById(currencyName: String): Currency? = currencyDao.findByIdOrNull(currencyName)

    fun createCurrency(currency: Currency): Currency = currencyDao.save(currency)

    fun createListCurrency(listCurrency: List<Currency>): List<Currency> = listCurrency.map { createCurrency(it) }

}