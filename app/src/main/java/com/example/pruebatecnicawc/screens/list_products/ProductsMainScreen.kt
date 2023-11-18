package com.example.pruebatecnicawc.screens.list_products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.pruebatecnicawc.ui.theme.WhiteBackGroundApp
import com.example.pruebatecnicawc.viewmodel.ProductsViewModel

@Composable
fun ProductsMainScreen(navController: NavHostController, paddingValues: PaddingValues) {
    val productsViewModel = hiltViewModel<ProductsViewModel>()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackGroundApp)
    ) {
        Text(
            text = "Lista de Productos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            ListProducts(navController = navController, productsViewModel = productsViewModel)
        }
    }
}