package org.example.paymentservice.repository.model

import jakarta.persistence.*
import org.example.paymentservice.repository.model.view.ViewCourse

@Entity
@Table
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "currency_one", nullable = false)
    val currencyOne: Currency,

    @ManyToOne
    @JoinColumn(name = "currency_two", nullable = false)
    val currencyTwo: Currency,

    @Column(nullable = false)
    val course: Long
) {
    fun fromCourse(): ViewCourse =
        ViewCourse(
            id = id,
            currency_one = currencyOne.name,
            currency_two = currencyTwo.name,
            course = course
        )
}