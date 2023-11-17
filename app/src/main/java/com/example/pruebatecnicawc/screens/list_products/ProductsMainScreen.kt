package com.example.pruebatecnicawc.screens.list_products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ProductsMainScreen(navController:NavHostController, paddingValues: PaddingValues){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Screen inicial")
    }
}