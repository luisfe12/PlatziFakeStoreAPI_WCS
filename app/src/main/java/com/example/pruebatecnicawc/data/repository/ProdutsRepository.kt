package com.example.pruebatecnicawc.data.repository

import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.data.network.ProductService
import retrofit2.Response
import javax.inject.Inject

class ProdutsRepository @Inject constructor(
    private val productService: ProductService
) {
    suspend fun getProductsFromApi(): Response<List<ProductsResponseItem>> {
        return productService.getProducts()
    }
}