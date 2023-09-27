package com.firozpocyt.androidhiltwithmvvmexample.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.firozpocyt.androidhiltwithmvvmexample.models.ProductItem

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProducts(products: List<ProductItem>)

    @Query("SELECT * FROM ProductItem")
    fun getProducts(): List<ProductItem>
}