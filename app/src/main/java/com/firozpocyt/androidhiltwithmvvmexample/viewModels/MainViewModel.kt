package com.firozpocyt.androidhiltwithmvvmexample.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firozpocyt.androidhiltwithmvvmexample.models.ProductItem
import com.firozpocyt.androidhiltwithmvvmexample.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    val productLiveData : LiveData<List<ProductItem>>
        get() = productRepository.products

    init {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}
