package org.example.userservice

import org.springframework.http.HttpStatus

class UserNotFoundException (
    httpStatus: HttpStatus,
    message: String
) : Exception()