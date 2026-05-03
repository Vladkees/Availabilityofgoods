package com.example.availabilityofgoods.feature.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.availabilityofgoods.feature.ui.product.StoreViewModel


private val CARD_HEIGHT_SMALL = 80.dp
private val CARD_HEIGHT_LARGE = 200.dp
@Composable
fun MainScreen(navController: NavController, viewModel: StoreViewModel) {
    var text by remember { mutableStateOf("") }


    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.weight(1f),
                    label = { Text("Назва товару") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = {
                    var query = text.trim().lowercase()
                    if (text.isNotBlank()) {
                        navController.navigate("product_screen/${query}")
                    }
                }) {
                    Text("Шукати")
                }
            }

            SimpleLazyRow(items = viewModel.items, cardHeight = CARD_HEIGHT_SMALL, cardWidth = 120.dp)
            SimpleLazyRow(items = viewModel.items, cardHeight = CARD_HEIGHT_LARGE, fillMaxWidth = true)

            TextWithArrow()
            SimpleLazyRow(items = viewModel.items, cardHeight = 80.dp, cardWidth = 120.dp)
            Spacer(modifier = Modifier.height(16.dp))
            TextWithArrow()
            SimpleLazyRow(items = viewModel.items, cardHeight = 140.dp, cardWidth = 120.dp)
            ButtonRow()
        }
    }
}

@Composable
fun SimpleLazyRow(items: List<String>, cardHeight: Dp, cardWidth: Dp? = null, fillMaxWidth: Boolean = false) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .then(
                        if (fillMaxWidth) Modifier.fillParentMaxWidth() else Modifier.width(cardWidth ?: 100.dp)
                    )
                    .height(cardHeight)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(item)
                }
            }
        }
    }
}

@Composable
fun TextWithArrow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Title", fontSize = 18.sp)
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next")
        }
    }
}

@Composable
fun ButtonRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Button(onClick = {}, modifier = Modifier.weight(1f)) { Text("Button 1") }
        Button(onClick = {}, modifier = Modifier.weight(1.5f)) { Text("Button 2") }
        Button(onClick = {}, modifier = Modifier.weight(1f)) { Text("Button 3") }
    }
}