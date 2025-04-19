package com.example.taskfourkfd.repository.model.view

import com.example.taskfourkfd.repository.model.Course
import com.example.taskfourkfd.repository.model.Currency

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
