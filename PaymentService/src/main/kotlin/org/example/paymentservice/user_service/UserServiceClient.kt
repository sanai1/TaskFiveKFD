package org.example.paymentservice.user_service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@FeignClient(name = "UserService")
interface UserServiceClient {
    @GetMapping("v1/user/users/{user_id}")
    fun getUserById(@PathVariable("user_id") userUid: UUID): Users
}