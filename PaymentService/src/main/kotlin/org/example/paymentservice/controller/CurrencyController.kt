package org.example.paymentservice.controller

import org.example.paymentservice.repository.model.Currency
import org.example.paymentservice.service.CurrencyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1")
class CurrencyController(private val currencyService: CurrencyService) {

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