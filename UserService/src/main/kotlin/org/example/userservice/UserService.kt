package org.example.userservice

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val usersDao: UsersDao,
) {
    fun findAllUsers(): List<Users> = usersDao.findAll()

    fun getUserById(userId: UUID): Users? = usersDao.findByIdOrNull(userId)

    fun createUser(user: Users): Users {
        user.password = getEncoder().encode(user.password)
        return usersDao.save(user)
    }

    fun checkPermission(authHeader: String): String {
        val login = String(Base64.getDecoder().decode(authHeader.split(" ")[1])).split(":")[0]
        return usersDao.findByLogin(login).get().role
    }

    private fun getEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}