@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pruebatecnicawc

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebatecnicawc.navigation.NavGraphScreens

@Composable
fun AppScreen(){
    val navController = rememberNavController();

    val currentRoute = navController.currentBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {

        }
    ) {paddingValues ->

        NavGraphScreens(navController = navController, paddingValues = paddingValues)
    }
}