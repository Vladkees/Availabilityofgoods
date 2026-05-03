package com.example.availabilityofgoods.feature.domain

import java.time.LocalDateTime

data class ProductAvailability(
    val productId: String,
    val productName: String,
    val storeId: String,
    val quantity: Int,
    val price: Double,
    val lastUpdated: LocalDateTime
)
