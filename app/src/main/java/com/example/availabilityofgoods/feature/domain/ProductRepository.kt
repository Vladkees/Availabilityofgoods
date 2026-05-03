package com.example.availabilityofgoods.feature.domain

import com.example.availabilityofgoods.feature.data.mapper.toDomain
import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityEntity
import com.example.availabilityofgoods.feature.data.model.ProductAvailabilityDao
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductRepository @Inject constructor(
    private val dao: ProductAvailabilityDao,
    // later: private val api: StoreApiService
) {
    fun getAvailabilityForStore(storeId: String): Flow<List<ProductAvailability>> =
        dao.observeByStore(storeId)
            .map { list -> list.map { it.toDomain() } }
    }
