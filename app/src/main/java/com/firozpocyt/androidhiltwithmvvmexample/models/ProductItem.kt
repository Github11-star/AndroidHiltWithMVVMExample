package com.firozpocyt.androidhiltwithmvvmexample.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductItem(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)