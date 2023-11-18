package com.example.pruebatecnicawc.di

import com.example.pruebatecnicawc.HttpRoutes
import com.example.pruebatecnicawc.data.network.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(HttpRoutes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Provides
    @Singleton
    fun productsService(retrofit: Retrofit) =
         retrofit.create(ProductService::class.java);
}