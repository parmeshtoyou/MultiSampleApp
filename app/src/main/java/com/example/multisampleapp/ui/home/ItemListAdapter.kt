package com.example.multisampleapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multisampleapp.R
import com.example.multisampleapp.model.Post
import kotlinx.android.synthetic.main.recycler_view_item_layout.view.*

class ItemListAdapter : RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    private var itemList = mutableListOf<Post>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(itemModel: Post) {
            /*itemView.textView2.text = itemModel.text1
            itemView.textView3.text = itemModel.text2
            itemView.textView4.text = itemModel.text3
            itemView.textView5.text = itemModel.text4

            if (itemModel.text1.isEmpty()) {
                itemView.full_horizontal_line.visibility = View.INVISIBLE
                itemView.half_horizontal_line.visibility = View.VISIBLE
            } else {
                itemView.full_horizontal_line.visibility = View.VISIBLE
                itemView.half_horizontal_line.visibility = View.INVISIBLE
            }*/

            itemView.textView2.text = itemModel.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(itemList[position])
    }

    fun setData(listOfItem: List<Post>) {
        itemList.clear()
        itemList = listOfItem.toMutableList()
        notifyDataSetChanged()
    }
}