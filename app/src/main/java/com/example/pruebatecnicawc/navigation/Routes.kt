package com.example.pruebatecnicawc.navigation

sealed class Routes(private val route:String){
    object ScreenProducts:Routes("MainScreenProducts");
    object ScreenOnlyOneProduct:Routes("MainScreenOnlyOneProduct");
}
