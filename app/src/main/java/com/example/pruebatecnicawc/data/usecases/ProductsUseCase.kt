package com.example.pruebatecnicawc.data.usecases

import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.data.repository.ProdutsRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val produtsRepository: ProdutsRepository
) {

    suspend fun getLIstProducts(): List<ProductsResponseItem> {
        val services = produtsRepository.getProductsFromApi();

        return if (services.isSuccessful){
            val body = services.body()!!
            body;
        }else{
            emptyList<ProductsResponseItem>()
        }
    }
}