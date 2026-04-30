package com.example.availabilityofgoods.feature.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.availabilityofgoods.feature.ui.product.ProductViewModel

@Composable
fun ProductScreen(viewModel: ProductViewModel, objectName: String?){

    val products by viewModel.products.collectAsState()

    LazyColumn {
        items(products){ product ->
            if (product.name == objectName) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(60.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(product.name + " в " + product.store)

                    Button(onClick = {
                        viewModel.onToggleAvailability(product)
                    }) {
                        Text(if (product.available) "Є в кількості " + product.qty else "Немає")
                    }
                }
            }
        }
    }
}