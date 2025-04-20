package org.example.paymentservice.repository.model

import jakarta.persistence.*

@Entity
@Table
data class Currency(
    @Id
    @Column(nullable = false, unique = true)
    val name: String
)