package org.example.paymentservice.repository.dao

import org.example.paymentservice.repository.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseDao : JpaRepository<Course, Long>