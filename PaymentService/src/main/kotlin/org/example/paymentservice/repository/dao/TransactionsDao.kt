package org.example.paymentservice.repository.dao

import org.example.paymentservice.repository.model.Transactions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransactionsDao : JpaRepository<Transactions, UUID> {
    fun findByUser(user: UUID): List<Transactions>
}