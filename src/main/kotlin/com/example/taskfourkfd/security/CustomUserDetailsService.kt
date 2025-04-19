package com.example.taskfourkfd.security

import com.example.taskfourkfd.repository.dao.UsersDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class CustomUserDetailsService @Autowired constructor (
    private val usersDao: UsersDao
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = usersDao.findByLogin(username)

        return user.map { CustomUserDetails(it) }.orElseThrow { RuntimeException("User not found: $username") }
    }
}