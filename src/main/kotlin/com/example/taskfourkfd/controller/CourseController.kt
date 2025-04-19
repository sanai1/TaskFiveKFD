package com.example.taskfourkfd.controller

import com.example.taskfourkfd.repository.model.view.ViewCourse
import com.example.taskfourkfd.service.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class CourseController (private val courseService: CourseService) {

    @GetMapping("/user/courses")
    fun findAll(): List<ViewCourse> = courseService.findAllCourses()

    @GetMapping("/user/courses/{courseId}")
    fun getCourseById(@PathVariable("courseId") courseId: Long): ViewCourse? =
        courseService.getCourseById(courseId)

    @PostMapping("/admin/courses")
    fun createCourse(@RequestBody viewCourse: ViewCourse): ViewCourse? =
        courseService.createCourse(viewCourse)

    @PutMapping("/user/courses/{courseId}")
    fun updateCourseById(
        @PathVariable("courseId") courseId: Long,
        @RequestBody viewCourse: ViewCourse): ViewCourse? =
        courseService.updateCourse(courseId, viewCourse)

}