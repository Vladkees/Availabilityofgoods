package com.example.availabilityofgoods

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.availabilityofgoods.feature.ui.screens.MainScreen
import com.example.availabilityofgoods.feature.ui.screens.ProductScreen
import com.example.availabilityofgoods.feature.ui.theme.AvailabilityOfGoodsTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.availabilityofgoods.feature.ui.product.StoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AvailabilityOfGoodsTheme {
                val navController = rememberNavController()
                val viewModel: StoreViewModel = viewModel()

                NavHost(
                    navController = navController,
                    startDestination = "main_screen"
                ) {

                    composable("main_screen") {
                        MainScreen(navController, viewModel)
                    }
                    composable("product_screen/{objectName}") { backStackEntry ->
                        val objectName = backStackEntry.arguments?.getString("objectName")
                        ProductScreen(viewModel, objectName = objectName)
                    }

                }
            }
        }
    }
}

