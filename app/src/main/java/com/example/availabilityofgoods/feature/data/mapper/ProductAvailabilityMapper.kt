package com.example.availabilityofgoods.feature.data.mapper

import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityWithName
import com.example.availabilityofgoods.feature.domain.ProductAvailability
import java.time.LocalDateTime
import java.time.ZoneOffset

fun ProductAvailabilityWithName.toDomain(): ProductAvailability {
    return ProductAvailability(
        productId = this.productId,
        productName = this.productName,
        storeId = this.storeId,
        quantity = this.quantity,
        price = this.price,
        lastUpdated = LocalDateTime.ofEpochSecond(
            this.updatedAt,
            0,
            ZoneOffset.UTC
        )
    )
}