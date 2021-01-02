package com.example.multisampleapp.ui.home

import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE, sdk = [28])
class HomeViewModelTest : TestCase() {

    @Test
    fun testGetPostList() {
        val homeViewModel = HomeViewModel()

        homeViewModel.getPostList()

        homeViewModel.postLiveData.observeForever {
            assertNotNull(it)
            assertEquals(100, it.size)
            assertEquals(1, it[0].id)
            assertEquals(1, it[0].userId)
            assertEquals(
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                it[0].title
            )
            assertEquals(
                "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto",
                it[0].body
            )
        }
    }
}