package com.example.availabilityofgoods.feature.domain

import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityEntity
import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository(
    private val dao: ProductAvailabilityDao,
    // later: private val api: StoreApiService
) {
    fun getAvailabilityForStore(storeId: String): Flow<List<ProductAvailabilityEntity>> =
        dao.observeByStore(storeId)
            .map { list ->
                list.map { it.toDomain()}
            }
    }
