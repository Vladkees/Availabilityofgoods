package com.example.availabilityofgoods.feature.ui

import androidx.lifecycle.ViewModel
import com.example.availabilityofgoods.feature.domain.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

}