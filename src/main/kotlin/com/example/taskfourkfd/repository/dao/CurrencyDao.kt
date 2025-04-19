package com.example.taskfourkfd.repository.dao

import com.example.taskfourkfd.repository.model.Currency
import org.springframework.data.jpa.repository.JpaRepository

interface CurrencyDao : JpaRepository<Currency, String>