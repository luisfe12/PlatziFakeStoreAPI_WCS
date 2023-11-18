package com.example.pruebatecnicawc.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnicawc.data.database.dao.ProductsDao
import com.example.pruebatecnicawc.data.database.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductsDataBase:RoomDatabase() {
    abstract fun getProductsDao():ProductsDao
}