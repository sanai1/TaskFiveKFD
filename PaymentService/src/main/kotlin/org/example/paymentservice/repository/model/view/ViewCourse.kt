package org.example.paymentservice.repository.model.view

import org.example.paymentservice.repository.model.Course
import org.example.paymentservice.repository.model.Currency

data class ViewCourse(
    var id: Long = 0L,
    val currency_one: String,
    val currency_two: String,
    val course: Long
) {
    fun toCourse(currency_one: Currency, currency_two: Currency): Course =
        Course(
            currencyOne = currency_one,
            currencyTwo = currency_two,
            course = course
        )
    fun toCourse(id: Long, currency_one: Currency, currency_two: Currency): Course =
        Course(
            id = id,
            currencyOne = currency_one,
            currencyTwo = currency_two,
            course = course
        )
}
