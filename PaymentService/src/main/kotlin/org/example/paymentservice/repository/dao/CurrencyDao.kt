package org.example.paymentservice.repository.dao

import org.example.paymentservice.repository.model.Currency
import org.springframework.data.jpa.repository.JpaRepository

interface CurrencyDao : JpaRepository<Currency, String>