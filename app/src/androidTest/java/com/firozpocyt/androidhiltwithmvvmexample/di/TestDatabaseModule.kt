package com.firozpocyt.androidhiltwithmvvmexample.di

import android.content.Context
import androidx.room.Room
import com.firozpocyt.androidhiltwithmvvmexample.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [DatabaseModule::class])
@Module
class TestDatabaseModule {

    @Singleton
    @Provides
    fun providesTestDB(@ApplicationContext context: Context) : FakerDB{
        return Room.inMemoryDatabaseBuilder(
            context,
            FakerDB::class.java
        ).allowMainThreadQueries().build()
    }
}