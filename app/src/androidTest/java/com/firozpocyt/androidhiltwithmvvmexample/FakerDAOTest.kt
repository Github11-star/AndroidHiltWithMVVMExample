package com.firozpocyt.androidhiltwithmvvmexample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.firozpocyt.androidhiltwithmvvmexample.db.FakerDAO
import com.firozpocyt.androidhiltwithmvvmexample.db.FakerDB
import com.firozpocyt.androidhiltwithmvvmexample.models.ProductItem
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class FakerDAOTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var fakerDB: FakerDB
    private lateinit var fakerDAO: FakerDAO

    @Before
    fun setUp(){
        hiltAndroidRule.inject()
        fakerDAO = fakerDB.getFakerDAO()
    }

    @Test
    fun insertProduct_returnSingleProduct() = runTest{
        val productItem = ProductItem("","",1,"",12.33, "Test Product")
        fakerDAO.addProducts(listOf(productItem))
        val result = fakerDAO.getProducts()
        Assert.assertEquals(1, result.size)
    }

    @After
    fun closeDatabase(){
        fakerDB.close()
    }
}