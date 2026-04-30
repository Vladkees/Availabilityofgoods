package com.example.availabilityofgoods.feature.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "stores",
    foreignKeys = [ForeignKey(
        entity = StoreChainEntity::class,
        parentColumns = ["id"],
        childColumns = ["chainId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("chainId")]
)
data class StoreEntity(
 @PrimaryKey val id: String,
    val chainId: String,
    val address :String,
    val latitude: Double?,
    val longitude: Double?

)
