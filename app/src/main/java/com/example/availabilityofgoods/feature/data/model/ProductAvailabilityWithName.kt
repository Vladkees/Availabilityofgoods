package com.example.availabilityofgoods.feature.data.model

data class ProductAvailabilityWithName(
    val storeId: String,
    val productId: String,
    val productName: String,
    val quantity: Int,
    val price: Double,
    val updatedAt: Long
)
