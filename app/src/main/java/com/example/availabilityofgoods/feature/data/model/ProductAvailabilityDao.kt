package com.example.availabilityofgoods.feature.data.model

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductAvailabilityDao {
    @Query("SELECT *FROM product_availability WHERE storeId = :storeId")
    fun observeByStore(storeId: String):Flow<List<ProductAvailabilityEntity>>

    @Upsert
    suspend fun upsert(items: List<ProductAvailabilityEntity>)
}