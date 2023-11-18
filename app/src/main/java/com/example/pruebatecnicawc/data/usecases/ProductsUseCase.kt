package com.example.pruebatecnicawc.data.usecases

import android.util.Log
import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.data.repository.ProdutsRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val produtsRepository: ProdutsRepository
) {

    suspend fun getLIstProducts(): List<ProductsResponseItem> {
        val services = produtsRepository.getProductsFromApi();
        Log.i("Services", "${services}")
        return if (services.isSuccessful){
            val body = services.body()!!
            Log.i("ServicesBody", "${body}")
            body;
        }else{
            Log.i("ErrorServices", "${services}")
            emptyList<ProductsResponseItem>()
        }
    }
}