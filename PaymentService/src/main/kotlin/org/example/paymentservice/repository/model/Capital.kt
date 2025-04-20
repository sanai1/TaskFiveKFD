package org.example.paymentservice.repository.model

import jakarta.persistence.*
import org.example.paymentservice.repository.model.view.ViewCapital
import java.util.UUID

@Entity
@Table
data class Capital(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @Column(name = "user_uid")
    val user: UUID,

    @ManyToOne
    @JoinColumn(name = "currency_id")
    val currency: Currency,

    @Column(nullable = false)
    val amount: Long
) {
    fun fromCapital(): ViewCapital =
        ViewCapital(
            id = id,
            user_id = user,
            currency = currency.name,
            amount = amount
        )
}