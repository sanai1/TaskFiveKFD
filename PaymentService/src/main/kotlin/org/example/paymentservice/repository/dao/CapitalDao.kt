package org.example.paymentservice.repository.dao

import org.example.paymentservice.repository.model.Capital
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CapitalDao : JpaRepository<Capital, UUID> {
    fun findByUser(user: UUID): List<Capital>
}