@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pruebatecnicawc.screens.list_products

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.pruebatecnicawc.ui.theme.GreyCardProduct
import com.example.pruebatecnicawc.viewmodel.ProductsViewModel

@Composable
fun ListProducts(
    navController: NavHostController,
    sortedState: Boolean,
    productsViewModel: ProductsViewModel
) {
    val products by productsViewModel.products.collectAsStateWithLifecycle();
    val name by productsViewModel.nameSearch.collectAsStateWithLifecycle()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(GreyCardProduct),
        contentAlignment = Alignment.Center
    ) {
        SearchProductdTextField(name = name, onCurrentName = {
            productsViewModel.changeNameProductToSearch(it)
        })
    }
    Spacer(Modifier.height(10.dp))
    if (products.isNotEmpty()) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            var newLis = products.filter { productData ->
                productData.title.contains(name, ignoreCase = true)
            }
            if (sortedState){
                newLis = newLis.sortedBy { it.price }
            }
            items(newLis) { product ->
                CardProductFromList(navController = navController, product = product)
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}


@Composable
fun SearchProductdTextField(name: String, onCurrentName: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = { onCurrentName(it) },
        singleLine = true,
        label = { Text(text = "Producto", fontSize = 15.sp, fontWeight = FontWeight.SemiBold) },
        placeholder = { Text(text = "Buscar Producto") },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, bottom = 5.dp)
    )
}