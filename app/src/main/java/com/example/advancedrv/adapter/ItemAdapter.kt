package com.example.advancedrv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedrv.databinding.ItemDataBinding
import com.example.advancedrv.databinding.ItemHeaderBinding
import com.example.advancedrv.model.Item
import com.example.advancedrv.viewholder.DataViewHolder
import com.example.advancedrv.viewholder.HeaderViewHolder

class ItemAdapter : ListAdapter<Item, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Item.TYPE_HEADER -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemHeaderBinding.inflate(inflater, parent, false)
                HeaderViewHolder(binding)
            }
            else -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemDataBinding.inflate(inflater, parent, false)
                DataViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is Item.Header -> (holder as HeaderViewHolder).bind(item)
            is Item.DataItem -> (holder as DataViewHolder).bind(item)
        }
    }
}
