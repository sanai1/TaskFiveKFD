package com.example.taskfourkfd.repository.model

import com.example.taskfourkfd.repository.model.view.ViewCourse
import jakarta.persistence.*

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