package com.example.taskfourkfd.repository.model

import com.example.taskfourkfd.repository.model.view.ViewCapital
import jakarta.persistence.*

@Entity
@Table
data class Capital(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "user_uid")
    val user: Users,

    @ManyToOne
    @JoinColumn(name = "currency_id")
    val currency: Currency,

    @Column(nullable = false)
    val amount: Long
) {
    fun fromCapital(): ViewCapital =
        ViewCapital(
            id = id,
            user_id = user.uid,
            currency = currency.name,
            amount = amount
        )
}