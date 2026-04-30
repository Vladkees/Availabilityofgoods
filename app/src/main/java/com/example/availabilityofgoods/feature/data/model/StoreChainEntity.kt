package com.example.availabilityofgoods.feature.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "store_chains")
data class StoreChainEntity(
    @PrimaryKey val id: String,
    val name: String,
    val logoUrl: String?
)
