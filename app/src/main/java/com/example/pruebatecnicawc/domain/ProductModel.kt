package com.example.pruebatecnicawc.domain

import com.example.pruebatecnicawc.data.Category
import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.data.database.entity.ProductEntity

data class ProductModel(
    val category: Category,
    val creationAt: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String,
    val updatedAt: String
)

fun ProductsResponseItem.toDomain() = ProductModel(
    category = category,
    creationAt = creationAt,
    description = description,
    id = id,
    images = images,
    price = price,
    title = title,
    updatedAt = updatedAt
)

fun ProductEntity.toDomain() = ProductModel(
    category = category,
    creationAt = creationAt,
    description = description,
    id = id,
    images = images,
    price = price,
    title = title,
    updatedAt = updatedAt
)