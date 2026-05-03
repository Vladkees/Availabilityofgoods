package com.example.availabilityofgoods.feature.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.availabilityofgoods.feature.domain.ProductAvailability
import com.example.availabilityofgoods.feature.domain.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _storeId = MutableStateFlow("")
    private val _items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    val items: List<String>
        get() = _items

    @OptIn(ExperimentalCoroutinesApi::class)
    val availability: StateFlow<List<ProductAvailability>> = _storeId
        .flatMapLatest { id ->
            if (id.isEmpty()) flowOf(emptyList())
            else productRepository.getAvailabilityForStore(id)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun setStore(storeId: String) {
        _storeId.value = storeId
    }
}