package com.example.taskfourkfd.repository.model

import com.example.taskfourkfd.repository.model.view.ViewTransactions
import jakarta.persistence.*

@Entity
@Table
data class Transactions(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "user_uid", nullable = false)
    val user: Users,

    @ManyToOne
    @JoinColumn(name = "currency_one", nullable = false)
    val currencyOne: Currency,

    @ManyToOne
    @JoinColumn(name = "currency_two", nullable = false)
    val currencyTwo: Currency,

    @Column(nullable = false)
    val course: Long,

    @Column(name = "summa_one", nullable = false)
    val summaOne: Long,

    @Column(name = "summa_two", nullable = false)
    val summaTwo: Long

) {
    fun fromTransaction(): ViewTransactions =
        ViewTransactions(
            id = id,
            user_uid = user.uid,
            currency_one = currencyOne.name,
            currency_two = currencyTwo.name,
            course = course,
            summa_one = summaOne,
            summa_two = summaTwo
        )
}
