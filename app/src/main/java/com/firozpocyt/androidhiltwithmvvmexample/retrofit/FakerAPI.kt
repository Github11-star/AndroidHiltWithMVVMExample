package com.firozpocyt.androidhiltwithmvvmexample.retrofit

import com.firozpocyt.androidhiltwithmvvmexample.models.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<ProductItem>>
}