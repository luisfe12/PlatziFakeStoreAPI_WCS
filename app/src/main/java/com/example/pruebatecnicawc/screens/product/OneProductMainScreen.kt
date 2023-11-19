package com.example.pruebatecnicawc.screens.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.pruebatecnicawc.globalProduct
import com.example.pruebatecnicawc.newDate
import com.example.pruebatecnicawc.ui.theme.GreyCardProduct
import com.example.pruebatecnicawc.ui.theme.WhiteBackGroundApp

@Composable
fun OneProductMainScreen(navController: NavHostController, paddingValues: PaddingValues) {

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues = paddingValues)) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .background(WhiteBackGroundApp)
                .padding(15.dp),
            elevation = CardDefaults.cardElevation(15.dp),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(GreyCardProduct)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CardImageOneProduct(
                    modifier = Modifier,
                    imageLink = globalProduct!!.images[0]
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = globalProduct!!.title,
                        fontSize = 15.sp,

                        );
                }

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = globalProduct!!.description,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                );
                Spacer(modifier = Modifier.height(5.dp))
                CategoryProductRow(
                    modifier = Modifier.weight(1f),
                    categoryName = globalProduct!!.category.name
                )
                Spacer(modifier = Modifier.height(5.dp))
                DateCreationProductRow(
                    modifier = Modifier.weight(1f),
                    creation = globalProduct!!.creationAt
                )
                Spacer(modifier = Modifier.height(5.dp))
                DateUpdateProductRow(
                    modifier = Modifier.weight(1f),
                    update = globalProduct!!.updatedAt
                )
                Spacer(modifier = Modifier.height(5.dp))
                PriceProductRow(
                    modifier = Modifier.weight(1f),
                    price = globalProduct!!.price.toString()
                )
            }
        }
    }
}

@Composable
fun CardImageOneProduct(modifier: Modifier, imageLink: String) {
    val localConfiguration = LocalConfiguration.current
    val heightInDp = localConfiguration.screenHeightDp.dp;
    val heightCard = heightInDp / 3
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(WhiteBackGroundApp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0E5E5))
                .height(heightCard), contentAlignment = Alignment.Center
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageLink) // Set the target size to load the image at.
                    .build()
            )

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun CategoryProductRow(modifier: Modifier, categoryName: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Categoria: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = categoryName, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun PriceProductRow(modifier: Modifier, price: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Precio: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "$price$", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun DateCreationProductRow(modifier: Modifier, creation: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Creado: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = newDate(creation), fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun DateUpdateProductRow(modifier: Modifier, update: String) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Actualizado: ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = newDate(update), fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    }
}