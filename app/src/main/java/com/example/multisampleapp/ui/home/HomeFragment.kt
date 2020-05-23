package com.example.multisampleapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multisampleapp.R
import com.example.multisampleapp.model.ItemModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var listAdapter: ItemListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        observeItemList()
    }

    private fun initView() {
        listAdapter = ItemListAdapter()
        recyclerView1.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }
    }

    private fun observeItemList() {
        homeViewModel.dummyList.observe(viewLifecycleOwner, Observer {
            updateRecyclerView(it)
        })
    }

    private fun initViewModel() {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private fun updateRecyclerView(itemList: List<ItemModel>) {
        listAdapter.setData(itemList)
    }
}
