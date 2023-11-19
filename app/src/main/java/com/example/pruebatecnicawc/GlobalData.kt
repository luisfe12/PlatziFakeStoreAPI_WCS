package com.example.pruebatecnicawc

import com.example.pruebatecnicawc.domain.ProductModel

var globalProduct:ProductModel? = null;


fun newDate(date:String): String {
    val splitDate = date.split("T")
    return splitDate[0]
}