package com.example.taskfourkfd.repository.dao

import com.example.taskfourkfd.repository.model.Transactions
import com.example.taskfourkfd.repository.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransactionsDao : JpaRepository<Transactions, UUID> {
    fun findByUser(user: Users): List<Transactions>
}