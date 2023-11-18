package com.example.pruebatecnicawc.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebatecnicawc.data.Category

@Entity("product_table")
data class ProductEntity(

    @ColumnInfo(name = "category") val category: Category,
    @ColumnInfo(name = "creationAt") val creationAt: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "images") val image:String,
    @ColumnInfo(name = "prices") val prices:Int,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "updatedAt") val updatedAt:String,
)