package com.example.multisampleapp.ui.home

import com.example.multisampleapp.MainCoroutineRule
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(RoboelectricTestRunner::class)
@ObsoleteCoroutinesApi
class HomeViewModelTest : TestCase() {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @ExperimentalCoroutinesApi
    val dispatcher = TestCoroutineDispatcher()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown1() {
        Dispatchers.resetMain()
    }

    fun testGetPostList() {
        val homeViewModel = HomeViewModel()

        homeViewModel.getPostList()

        homeViewModel.postLiveData.observeForever {
            assertNotNull(it)
        }
    }
}