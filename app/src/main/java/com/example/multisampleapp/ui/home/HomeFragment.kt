package com.example.multisampleapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multisampleapp.R
import com.example.multisampleapp.model.ItemModel
import com.example.multisampleapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var listAdapter: ItemListAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        observeItemList()
        observeUser()
    }

    private fun initView() {
        listAdapter = ItemListAdapter()
        recyclerView1.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }

        fetchUser.setOnClickListener {
            mainViewModel.getUser()
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

        recyclerView1.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                val layoutManager = recyclerView1.layoutManager as LinearLayoutManager
                val numItems = recyclerView.adapter?.itemCount ?: 0
                val indexOfLastVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition()
                if (indexOfLastVisibleItem >= numItems - 1) {
                    listStatus.text = "Scroll Up"
                } else if (layoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    listStatus.text = "Scroll Down"
                }
            }
        })

        listStatus.text = "Scroll Down"
    }

    private fun observeUser() {
        mainViewModel.userLiveData.observe(viewLifecycleOwner, {
            it?.let {
                userTextView.text = it.name
            } ?: handleError()
        })
    }

    private fun handleError() {
        userTextView.text = "Error!"
    }

    companion object {
        private val TAG = HomeFragment::class.java.simpleName
    }
}
