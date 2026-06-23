package com.example.advancedrv.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedrv.databinding.ItemDataBinding
import com.example.advancedrv.model.Item

class DataViewHolder constructor(
    internal val binding: ItemDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item.DataItem) {
        binding.data = item
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): DataViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemDataBinding.inflate(inflater, parent, false)
            return DataViewHolder(binding)
        }
    }
}
