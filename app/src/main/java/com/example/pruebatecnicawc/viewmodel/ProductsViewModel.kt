package com.example.pruebatecnicawc.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicawc.data.ProductsResponseItem
import com.example.pruebatecnicawc.data.usecases.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase
):ViewModel() {
    private val _products = MutableStateFlow<List<ProductsResponseItem>>(emptyList());
    private val _isOrderedPreice = MutableStateFlow<Boolean>(false);
    val products:StateFlow<List<ProductsResponseItem>> = _products.asStateFlow();
    val isOrderedPreice:StateFlow<Boolean> = _isOrderedPreice.asStateFlow();

    init {
        viewModelScope.launch {
            try {
                _products.value = productsUseCase.getLIstProducts();
            }catch (e:Exception){
                Log.i("ErrorProducts", "${e.message}");
            }
        }
    }
}