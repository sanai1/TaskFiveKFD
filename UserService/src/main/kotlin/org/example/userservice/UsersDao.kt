package org.example.userservice

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersDao : JpaRepository<Users, UUID> {
    fun findByLogin(login: String): Optional<Users>
}