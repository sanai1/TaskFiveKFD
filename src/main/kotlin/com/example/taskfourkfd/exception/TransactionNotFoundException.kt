package com.example.taskfourkfd.exception

import org.springframework.http.HttpStatus

class TransactionNotFoundException(
    httpStatus: HttpStatus,
    message: String
) : Exception()