package com.example.multisampleapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.multisampleapp.apis.RetrofitClient
import com.example.multisampleapp.model.Post
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val apiService = RetrofitClient.getNodeService()

    private val mutablePostList = MutableLiveData<List<Post>>()

    /* private fun getDummyLocationList(): List<ItemModel> {
         return groupByText1(
             listOf(
                 ItemModel("Text1", "Text2", "Text3", "Text4"),
                 ItemModel("Text1", "Text2", "Text3", "Text4"),
                 ItemModel("Text1", "Text2", "Text3", "Text4"),
                 ItemModel("Text1", "Text2", "Text3", "Text4")
                 *//*ItemModel("Text2", "Text2", "Text3", "Text4"),
                ItemModel("Text2", "Text2", "Text3", "Text4"),
                ItemModel("Text2", "Text2", "Text3", "Text4"),
                ItemModel("Text3", "Text2", "Text3", "Text4"),
                ItemModel("Text4", "Text2", "Text3", "Text4"),
                ItemModel("Last Item", "Text2", "Text3", "Text4")*//*
            ).toMutableList()
        )
    }*/

    /*private fun groupByText1(list: MutableList<ItemModel>): List<ItemModel> {
        val groupByText1 = list.groupBy { it.text1 }
        groupByText1.forEach { entry ->
            entry.value.subList(1, entry.value.size).map { it.text1 = "" }
        }

        val mutableList = mutableListOf<ItemModel>()
        groupByText1.forEach() { entry ->
            entry.value.forEach {
                mutableList.add(it)
            }
        }
        mutableList.forEach {
            println(it)
        }
        return mutableList
    }*/

    val postLiveData: LiveData<List<Post>>
        get() = mutablePostList

    fun getPostList() {
        viewModelScope.launch {
            val postList = apiService.getPostList()
            println("Post size: ${postList.size}")
            mutablePostList.postValue(postList)
        }
    }
}