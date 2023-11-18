package com.example.pruebatecnicawc.screens.list_products

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.pruebatecnicawc.ui.theme.GreyCardProduct
import com.example.pruebatecnicawc.ui.theme.WhiteBackGroundApp
import com.example.pruebatecnicawc.viewmodel.ProductsViewModel

@Composable
fun ProductsMainScreen(navController: NavHostController, paddingValues: PaddingValues) {
    val productsViewModel = hiltViewModel<ProductsViewModel>()
    val expandedState by productsViewModel.expandedDDM.collectAsStateWithLifecycle();
    val nameOption by productsViewModel.nameOptionSort.collectAsStateWithLifecycle();
    val sortedState by productsViewModel.isSortedPreice.collectAsStateWithLifecycle();
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackGroundApp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreyCardProduct), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Lista de Productos",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(5.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            ExpandedOptionSorted(
                expandedState = expandedState,
                orderList = sortedState,
                optionName = nameOption,
                productsViewModel = productsViewModel
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
        ) {
            ListProducts(
                navController = navController,
                sortedState = sortedState,
                productsViewModel = productsViewModel
            )
        }
    }
}


@Composable
fun ExpandedOptionSorted(
    expandedState: Boolean,
    orderList: Boolean,
    optionName: String,
    productsViewModel: ProductsViewModel
) {

    Box(modifier = Modifier, contentAlignment = Alignment.CenterEnd) {
        IconButton(onClick = { productsViewModel.changeExpandedState(!expandedState) }) {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expandedState,
            onDismissRequest = { productsViewModel.changeExpandedState(false) }
        ) {
            DropdownMenuItem(
                text = { Text(optionName) },
                onClick = {
                    productsViewModel.changeExpandedState(!expandedState)
                    productsViewModel.changeOrderProducts(!orderList)
                }
            )

        }
    }
}