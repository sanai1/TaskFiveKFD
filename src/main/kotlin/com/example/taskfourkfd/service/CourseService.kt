package com.example.taskfourkfd.service

import com.example.taskfourkfd.repository.dao.CourseDao
import com.example.taskfourkfd.repository.dao.CurrencyDao
import com.example.taskfourkfd.repository.model.view.ViewCourse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CourseService (
    private val courseDao: CourseDao,
    private val currencyDao: CurrencyDao
) {

    fun findAllCourses(): List<ViewCourse> {
        val listViewCourses = emptyList<ViewCourse>().toMutableList()
        courseDao.findAll().forEach { listViewCourses.add(it.fromCourse()) }
        return listViewCourses
    }

    fun getCourseById(courseId: Long): ViewCourse? = courseDao.findByIdOrNull(courseId)?.fromCourse()

    fun createCourse(viewCourse: ViewCourse): ViewCourse? {
        val currencyOne = currencyDao.findByIdOrNull(viewCourse.currency_one)
        val currencyTwo = currencyDao.findByIdOrNull(viewCourse.currency_two)
        return if (currencyOne != null && currencyTwo != null) {
            val course = courseDao.save(viewCourse.toCourse(currencyOne, currencyTwo))
            viewCourse.id = course.id
            viewCourse
        } else null
    }

    fun updateCourse(id: Long, viewCourse: ViewCourse): ViewCourse? {
        viewCourse.id = id
        val currencyOne = currencyDao.findByIdOrNull(viewCourse.currency_one)
        val currencyTwo = currencyDao.findByIdOrNull(viewCourse.currency_two)
        return if (currencyOne != null && currencyTwo != null) {
            val course = courseDao.save(viewCourse.toCourse(viewCourse.id, currencyOne, currencyTwo))
            viewCourse.id = course.id
            viewCourse
        } else null
    }

}