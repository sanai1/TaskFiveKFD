package com.example.taskfourkfd.controller

import com.example.taskfourkfd.repository.model.Currency
import com.example.taskfourkfd.service.CurrencyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1")
class CurrencyController (private val currencyService: CurrencyService) {

    @GetMapping("/user/currency")
    fun getAllCurrencies(): List<Currency> = currencyService.getAllCurrencies()

    @GetMapping("/user/currency/{currencyId}")
    fun getCurrencyById(@PathVariable currencyId: String): Currency? =
        currencyService.getCurrencyById(currencyId)

    @PostMapping("/admin/currency")
    fun createCurrency(@RequestBody currency: Currency): Currency =
        currencyService.createCurrency(currency)

    @PostMapping("admin/currency/list")
    fun createListCurrencies(@RequestBody listCurrency: List<Currency>): List<Currency> =
        currencyService.createListCurrency(listCurrency)


}