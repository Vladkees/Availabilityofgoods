package com.example.availabilityofgoods.feature.ui.product

import androidx.lifecycle.ViewModel
import com.example.availabilityofgoods.feature.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository
    private val _products = MutableStateFlow <List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        loadProducts()
    }

    private fun loadProducts(){
        _products.value = repository.getProducts()
    }

    fun onToggleAvailability(product: Product){
        _products.value = _products.value.map {
            if(it.id == product.id){
                repository.toggleAvailability(it)
            } else it
        }
    }
}