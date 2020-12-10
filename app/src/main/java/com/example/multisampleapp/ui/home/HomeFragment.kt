package com.example.multisampleapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multisampleapp.R
import com.example.multisampleapp.model.ItemModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var listAdapter: ItemListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
        observeItemList()

        /*(requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager).apply {
            setPrimaryClip(ClipData.newPlainText("simple text", "some other text"))
        }*/

        val database = FirebaseDatabase.getInstance("https://multisampleapp-default-rtdb.firebaseio.com/")
        val myRef = database.getReference("fName")

        saveInfo.setOnClickListener {
            //myRef.setValue("Parmesh")
            showToastMsg("Hello World")
        }


        myRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                //showToastMsg("on Cancelled: ${p0.message}")
            }

            override fun onDataChange(p0: DataSnapshot) {
                //showToastMsg("onDataChange key:${p0.key} and value:${p0.value}")
            }
        })
    }

    fun showToastMsg(msg: String?) {
        requireActivity().runOnUiThread(Runnable {
            Toast.makeText(
                requireContext(),
                msg,
                Toast.LENGTH_LONG
            ).show()
        })
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

    companion object {
        private val TAG = HomeFragment::class.java.simpleName
    }
}
