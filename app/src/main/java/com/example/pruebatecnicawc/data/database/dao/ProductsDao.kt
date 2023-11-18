package com.example.pruebatecnicawc.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebatecnicawc.data.database.entity.ProductEntity

@Dao
interface ProductsDao {

    @Query("SELECT * FROM product_table")
    suspend fun getAllProducts(): List<ProductEntity>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProducts(products:List<ProductEntity>);

}