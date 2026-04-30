package com.example.availabilityofgoods.feature.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TestScreen(name: String){
    Column {
        Text("Hello, $name")
    }
}