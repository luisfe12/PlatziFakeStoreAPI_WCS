package com.example.pruebatecnicawc.di

import android.content.Context
import androidx.room.Room
import com.example.pruebatecnicawc.data.database.ProductsDataBase
import com.example.pruebatecnicawc.data.database.dao.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val PRODUCTS_DATABASE_NAME = "products_database";

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext contex: Context) =
        Room.databaseBuilder(contex, ProductsDataBase::class.java, PRODUCTS_DATABASE_NAME).build();

    @Singleton
    @Provides
    fun providesDao(db:ProductsDataBase) = db.getProductsDao();
}