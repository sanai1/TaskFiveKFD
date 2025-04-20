package org.example.userservice

import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("v1")
class UserController(private val userService: UserService) {
    @GetMapping("/admin/users")
    fun getAllUsers(): List<Users> = userService.findAllUsers()

    @GetMapping("/user/users/{user_id}")
    fun getUserById(@PathVariable("user_id") userId: UUID): Users? =
        userService.getUserById(userId)

    @PostMapping("/users")
    fun createUser(@RequestBody user: Users): Users = userService.createUser(user)

    @GetMapping("/auth/check-role")
    fun checkPermission(
        @RequestHeader(HttpHeaders.AUTHORIZATION) authHeader: String
    ): String {
        val role = userService.checkPermission(authHeader)
        return role
    }
}
