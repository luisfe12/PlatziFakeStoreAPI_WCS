package com.example.pruebatecnicawc.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pruebatecnicawc.screens.list_products.ProductsMainScreen
import com.example.pruebatecnicawc.screens.product.OneProductMainScreen

@Composable
fun NavGraphScreens(navController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Routes.ScreenProducts.route,
    ){
        composable(Routes.ScreenProducts.route){
            ProductsMainScreen(navController = navController, paddingValues = paddingValues);
        }
        composable(Routes.ScreenOnlyOneProduct.route){
            OneProductMainScreen(navController = navController, paddingValues = paddingValues);
        }
    }
}