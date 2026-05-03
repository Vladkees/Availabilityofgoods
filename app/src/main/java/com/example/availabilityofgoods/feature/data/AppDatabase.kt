package com.example.availabilityofgoods.feature.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityDao
import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityEntity
import com.example.availabilityofgoods.feature.data.model.ProductEntity
import com.example.availabilityofgoods.feature.data.model.StoreChainEntity
import com.example.availabilityofgoods.feature.data.model.StoreEntity

@Database(
    entities = [
        StoreChainEntity::class,
        StoreEntity::class,
        ProductEntity::class,
        ProductAvailabilityEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productAvailabilityDao(): ProductAvailabilityDao
}