package com.example.multisampleapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multisampleapp.model.ItemModel

class HomeViewModel : ViewModel() {

    private val _dummyItemList = MutableLiveData<List<ItemModel>>().apply {
        value = getDummyLocationList()
    }

    private fun getDummyLocationList(): List<ItemModel> {
        return groupByText1(
            listOf(
                ItemModel("Text1", "Text2", "Text3", "Text4"),
                ItemModel("Text1", "Text2", "Text3", "Text4"),
                ItemModel("Text1", "Text2", "Text3", "Text4"),
                ItemModel("Text1", "Text2", "Text3", "Text4"),
                ItemModel("Text2", "Text2", "Text3", "Text4"),
                ItemModel("Text2", "Text2", "Text3", "Text4"),
                ItemModel("Text3", "Text2", "Text3", "Text4"),
                ItemModel("Text4", "Text2", "Text3", "Text4"),
                ItemModel("Text5", "Text2", "Text3", "Text4")
            ).toMutableList()
        )
    }

    fun getItemCount() = dummyList.value?.size

    fun getItemAt(index: Int) = dummyList.value?.get(index)

    private fun groupByText1(list: MutableList<ItemModel>): List<ItemModel> {
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
    }

    val dummyList: LiveData<List<ItemModel>> = _dummyItemList
}