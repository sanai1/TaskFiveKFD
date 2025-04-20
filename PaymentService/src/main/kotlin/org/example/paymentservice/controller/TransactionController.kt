package org.example.paymentservice.controller

import org.example.paymentservice.repository.model.view.ViewTransactions
import org.example.paymentservice.service.TransactionService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("v1/transactions")
class TransactionController(
    private val transactionService: TransactionService
) {
    @GetMapping("/{user_id}")
    fun getTransactions(@PathVariable("user_id") userId: UUID):  List<ViewTransactions> =
        transactionService.getUserTransactions(userId)

    @PostMapping
    fun createUserTransaction(@RequestBody viewTransactions: ViewTransactions): ViewTransactions? =
        transactionService.createTransaction(viewTransactions)
}
