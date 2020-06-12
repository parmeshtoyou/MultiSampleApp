package com.example.multisampleapp.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.multisampleapp.model.ItemModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

import org.junit.Assert.*

class HomeViewModelTest {

    @Test
    fun testDummyEmptyList() {
        val homeViewModel: HomeViewModel = mock()

        whenever(homeViewModel.dummyList).thenReturn(MutableLiveData(emptyList()))

        val listOfLocations = homeViewModel.dummyList

        assertNotNull(listOfLocations)

        assertTrue(listOfLocations.value?.size == 0)
    }

    @Test
    fun testDummyList() {
        val homeViewModel: HomeViewModel = mock()

        whenever(homeViewModel.dummyList).thenReturn(
            MutableLiveData(
                arrayListOf(
                    ItemModel("Text1", "Text2", "Text3", "Text4"),
                    ItemModel("Text2", "Text2", "Text3", "Text4"),
                    ItemModel("Text3", "Text2", "Text3", "Text4"),
                    ItemModel("Text4", "Text2", "Text3", "Text4")
                )
            )
        )

        val listOfLocations = homeViewModel.dummyList

        assertNotNull(listOfLocations)
        assertEquals(4, listOfLocations.value?.size)

    }

    @Test
    fun testDummyListNotEmpty() {
        val homeViewModel: HomeViewModel = mock()
        whenever(homeViewModel.getItemCount())
            .thenReturn(0)

        assertNotNull(homeViewModel.getItemCount())
        assertEquals(0, homeViewModel.getItemCount())
    }

    @Test
    fun testDummyListSingleItem() {
        val homeViewModel: HomeViewModel = mock()
        whenever(homeViewModel.getItemCount())
            .thenReturn(1)

        assertNotNull(homeViewModel.getItemCount())
        assertEquals(1, homeViewModel.getItemCount())

        whenever(homeViewModel.getItemAt(1)).thenReturn(
            ItemModel(
                "Text1",
                "Text2",
                "Text3",
                "Text4"
            )
        )
        val item = homeViewModel.getItemAt(1)
        assertEquals("Text1", item?.text1)
    }
}