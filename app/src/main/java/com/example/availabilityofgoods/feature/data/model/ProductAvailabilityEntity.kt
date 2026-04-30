package com.example.availabilityofgoods.feature.data.model

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "product_availability",
    primaryKeys = ["storeId", "productId"],
    foreignKeys = [
        ForeignKey(entity = StoreEntity::class,
            parentColumns = ["id"], childColumns = ["storeId"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = ProductEntity::class,
            parentColumns = ["id"], childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE)
    ]
)
data class ProductAvailabilityEntity(
    val storeId: String,
    val productId: String,
    val quantity: Int,
    val price: Double,
    val updatedAt: Long
)
