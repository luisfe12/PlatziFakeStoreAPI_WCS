package com.example.pruebatecnicawc.data.usecases

import android.util.Log
import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.data.database.entity.ProductEntity
import com.example.pruebatecnicawc.data.database.entity.toDatabse
import com.example.pruebatecnicawc.data.repository.ProdutsRepository
import com.example.pruebatecnicawc.domain.ProductModel
import com.example.pruebatecnicawc.domain.toDomain
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val produtsRepository: ProdutsRepository
) {

    suspend fun getLIstProducts(): List<ProductsResponseItem> {
        val services = produtsRepository.getProductsFromApi();
        return if (services.isSuccessful){
            val body = services.body()!!
            body
        }else{
            Log.i("ErrorServices", "${services}")
            emptyList()
        }
    }


    suspend fun getListProductsDb(): List<ProductEntity> {
        return produtsRepository.getProductsFromDB();
    }


    suspend fun sendProductsToViewModel(): List<ProductModel> {
        return if (getListProductsDb().isNotEmpty()){
            getListProductsDb().map { it.toDomain() }
        }else{
            val listFromApi = getLIstProducts()
            produtsRepository.insertProductsDB(listFromApi.map { it.toDatabse() })
            listFromApi.map { it.toDomain() }
        }
    }
}