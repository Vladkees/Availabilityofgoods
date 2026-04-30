package com.example.availabilityofgoods.feature.domain

import java.time.LocalDateTime

data class ProductAvailability(
    val productName: String,
    val quantity: Int,
    val price: Double,
    val lastUpdated: LocalDateTime
)
