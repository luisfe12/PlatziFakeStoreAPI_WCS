package com.example.pruebatecnicawc.screens.list_products

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.ui.theme.GreyCardBorderProductImage
import com.example.pruebatecnicawc.ui.theme.GreyCardProduct

@Composable
fun CardProductFromList(navController: NavHostController, product: ProductsResponseItem) {
    val localConfiguration = LocalConfiguration.current
    val heightInDp = localConfiguration.screenHeightDp.dp;
    val heightCard = heightInDp / 4
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(14.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreyCardProduct)
                .height(heightCard)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = product.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                modifier = Modifier
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            )
            ImageListProduct(modifier = Modifier.weight(1f), product.images[0]);
            Text(
                text = "${product.price.toString()}$",
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
        }
    }
}


@Composable
fun ImageListProduct(modifier: Modifier, imagePdr: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(3.dp),
                color = GreyCardBorderProductImage
            ), contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imagePdr) // Set the target size to load the image at.
                .build()
        )


        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .height(70.dp)
                .padding(5.dp)
        )

    }
}