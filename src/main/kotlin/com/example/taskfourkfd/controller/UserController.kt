package com.example.taskfourkfd.controller

import com.example.taskfourkfd.repository.model.Users
import com.example.taskfourkfd.repository.model.view.ViewTransactions
import com.example.taskfourkfd.service.UserService
import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("api/v1")
class UserController (private val userService: UserService) {

    @GetMapping("/admin/users")
    fun getAllUsers(): List<Users> = userService.findAllUsers()

    @GetMapping("/user/users/{user_id}")
    fun getUserById(@PathVariable("user_id") userId: UUID): Users? =
        userService.getUserById(userId)

    @GetMapping("/user/users/transactions")
    fun getTransactions(@PathParam("user_id") userId: UUID):  List<ViewTransactions> =
        userService.getUserTransactions(userId)

    @PostMapping("/user/users/transactions")
    fun createUserTransaction(@RequestBody viewTransactions: ViewTransactions): ViewTransactions? =
        userService.createTransaction(viewTransactions)

    @PostMapping("/users")
    fun createUser(@RequestBody user: Users): Users = userService.createUser(user)

}