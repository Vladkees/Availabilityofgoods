package com.example.availabilityofgoods.feature.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StoreWithProducts(
    @Embedded val store: StoreEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "storeId",
        associateBy = Junction(ProductAvailabilityEntity::class)
    )
    val product: List<ProductEntity>
)
