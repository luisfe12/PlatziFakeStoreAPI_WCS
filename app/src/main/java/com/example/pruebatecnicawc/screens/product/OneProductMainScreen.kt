package com.example.pruebatecnicawc.screens.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.pruebatecnicawc.globalProduct

@Composable
fun OneProductMainScreen(navController: NavHostController, paddingValues: PaddingValues) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(15.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CardImageOneProduct(
                modifier = Modifier.weight(6f),
                imageLink = globalProduct!!.images[0]
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = globalProduct!!.title,
                fontSize = 15.sp,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            );
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CardImageOneProduct(modifier: Modifier, imageLink: String) {
    val localConfiguration = LocalConfiguration.current
    val heightInDp = localConfiguration.screenHeightDp.dp;
    val heightCard = heightInDp / 3
    Card(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
