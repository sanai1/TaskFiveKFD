package com.example.taskfourkfd.exception

import org.springframework.http.HttpStatus

class UserNotFoundException (
    httpStatus: HttpStatus,
    message: String
) : Exception()