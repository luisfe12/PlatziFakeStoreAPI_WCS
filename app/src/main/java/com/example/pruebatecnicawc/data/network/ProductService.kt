package com.example.pruebatecnicawc.data.network

import com.example.pruebatecnicawc.HttpRoutes
import com.example.pruebatecnicawc.data.ProductsResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET(HttpRoutes.ALL_PRODUCTS)
    suspend fun getProducts():Response<List<ProductsResponseItem>>
}