package com.example.pruebatecnicawc.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.pruebatecnicawc.data.Category
import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.google.gson.Gson

@Entity("product_table")
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "category") val category: Category,
    @ColumnInfo(name = "creationAt") val creationAt: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "images") val images:List<String>,
    @ColumnInfo(name = "price") val price:Int,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "updatedAt") val updatedAt:String,
)

class StringListConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",")
    }

    @TypeConverter
    fun toString(list: List<String>): String {
        return list.joinToString(",")
    }
}

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String {
        return Gson().toJson(category)
    }

    @TypeConverter
    fun toCategory(categoryString: String): Category {
        return Gson().fromJson(categoryString, Category::class.java)
    }
}
fun ProductsResponseItem.toDatabse() = ProductEntity(
    category = category,
    creationAt = creationAt,
    description = description,
    id = id,
    images = images,
    price = price,
    title = title,
    updatedAt = updatedAt
);