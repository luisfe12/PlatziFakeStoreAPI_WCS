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
    private val _isSortedPreice = MutableStateFlow<Boolean>(false);
    private val _nameSearch = MutableStateFlow<String>("");
    private val _expandedDDM = MutableStateFlow<Boolean>(false);
    private val _nameOptionSort = MutableStateFlow<String>("Orden por precios");
    val products:StateFlow<List<ProductsResponseItem>> = _products.asStateFlow();
    val isSortedPreice:StateFlow<Boolean> = _isSortedPreice.asStateFlow();
    val nameSearch:StateFlow<String> = _nameSearch.asStateFlow();
    val expandedDDM:StateFlow<Boolean> = _expandedDDM.asStateFlow();
    val nameOptionSort:StateFlow<String> = _nameOptionSort.asStateFlow()


    fun changeNameProductToSearch(searchName:String){
        _nameSearch.value = searchName;
    }

    fun changeOrderProducts(newValue: Boolean){
        _isSortedPreice.value = newValue
        if (_nameOptionSort.value == "Orden por precios"){
            _nameOptionSort.value = "Quitar orden"
        }else{
            _nameOptionSort.value = "Orden por precios"
        }
    }
    fun changeExpandedState(newValue:Boolean){
        _expandedDDM.value = newValue;
    }

    init {
        viewModelScope.launch {
            try {
                _products.value = productsUseCase.getLIstProducts();
                Log.i("products", "${_products.value}")
            }catch (e:Exception){
                Log.i("ErrorProducts", "${e.message}");
            }
        }
    }
}