package com.firozpocyt.androidhiltwithmvvmexample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.firozpocyt.androidhiltwithmvvmexample.models.ProductItem

@Database(entities = [ProductItem::class], version = 1)
abstract class FakerDB: RoomDatabase() {

    abstract fun getFakerDAO() : FakerDAO
}