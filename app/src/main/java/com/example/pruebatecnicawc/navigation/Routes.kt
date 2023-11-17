package com.example.pruebatecnicawc.navigation

sealed class Routes(val route:String){
    object ScreenProducts:Routes("MainScreenProducts");
    object ScreenOnlyOneProduct:Routes("MainScreenOnlyOneProduct");
}
