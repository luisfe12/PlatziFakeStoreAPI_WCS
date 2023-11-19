package com.example.pruebatecnicawc.data.repository

import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.data.database.dao.ProductsDao
import com.example.pruebatecnicawc.data.database.entity.ProductEntity
import com.example.pruebatecnicawc.data.network.ProductService
import retrofit2.Response
import javax.inject.Inject

class ProdutsRepository @Inject constructor(
    private val productService: ProductService,
    private val productsDao: ProductsDao
) {
    suspend fun getProductsFromApi(): Response<List<ProductsResponseItem>> {
        return productService.getProducts()
    }

    suspend fun getProductsFromDB(): List<ProductEntity> {
        return productsDao.getAllProducts();
    }

    suspend fun insertProductsDB(products:List<ProductEntity>){
        return productsDao.insertAllProducts(products);
    }
}