package com.example.availabilityofgoods.feature.data.repository

object ProductRepository {

    fun getProducts(): List<Product>{
        return listOf(
            Product(1, "milk", store = "ATB", available = true, qty = 22),
            Product(2, "bread", store = "Silpo", available =  false, qty = 11),
            Product(3, "milk", store = "Silpo", available =  false, qty = 11)
        )
    }

    fun toggleAvailability(product: Product): Product{
        return product.copy(available = !product.available)
    }
}