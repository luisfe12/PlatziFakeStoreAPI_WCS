@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pruebatecnicawc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pruebatecnicawc.navigation.NavGraphScreens
import com.example.pruebatecnicawc.navigation.Routes

@Composable
fun AppScreen() {
    val navController = rememberNavController();

    val currentScreen = navController.currentBackStackEntryAsState().value
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.imagewcb),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(50.dp)
                    )
                }

            }, navigationIcon = {
                if (currentScreen?.destination?.route == Routes.ScreenOnlyOneProduct.route) {
                    IconButton(onClick = { navController.popBackStack(); }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }

            })
        }
    ) { paddingValues ->

        NavGraphScreens(navController = navController, paddingValues = paddingValues)
    }
}