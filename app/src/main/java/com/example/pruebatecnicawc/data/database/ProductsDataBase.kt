package com.example.pruebatecnicawc.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pruebatecnicawc.data.database.dao.ProductsDao
import com.example.pruebatecnicawc.data.database.entity.CategoryConverter
import com.example.pruebatecnicawc.data.database.entity.ProductEntity
import com.example.pruebatecnicawc.data.database.entity.StringListConverter

@Database(entities = [ProductEntity::class], version = 1)
@TypeConverters(StringListConverter::class, CategoryConverter::class)
abstract class ProductsDataBase:RoomDatabase() {
    abstract fun getProductsDao():ProductsDao
}