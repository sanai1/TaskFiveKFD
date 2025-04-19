package com.example.taskfourkfd.repository.dao

import com.example.taskfourkfd.repository.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseDao : JpaRepository<Course, Long>