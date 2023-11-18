package com.example.pruebatecnicawc.screens.list_products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pruebatecnicawc.data.ProductsResponseItem

@Composable
fun CardProductFromList(navController: NavHostController, product: ProductsResponseItem) {
    val context = LocalContext.current

    val displayMetrics = context.resources.displayMetrics
    val height = displayMetrics.heightPixels

    val heightCard = height / 4
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(14.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(heightCard.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = product.title, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(5.dp))
            ImageListProduct(modifier = Modifier.weight(1f));
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = product.title, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
        }
    }
}


@Composable
fun ImageListProduct(modifier: Modifier){
    Box(modifier = modifier) {

    }
}