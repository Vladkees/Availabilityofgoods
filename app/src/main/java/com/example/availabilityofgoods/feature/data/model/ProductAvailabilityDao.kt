package com.example.availabilityofgoods.feature.data.model

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductAvailabilityDao {

    @Query("""
        SELECT 
            pa.storeId,
            pa.productId,
            p.name AS productName,
            pa.quantity,
            pa.price,
            pa.updatedAt
        FROM product_availability pa
        INNER JOIN products p ON pa.productId = p.id
        WHERE pa.storeId = :storeId
    """)
    fun observeByStore(storeId: String): Flow<List<ProductAvailabilityWithName>>

    @Upsert
    suspend fun upsert(items: List<ProductAvailabilityEntity>)
}