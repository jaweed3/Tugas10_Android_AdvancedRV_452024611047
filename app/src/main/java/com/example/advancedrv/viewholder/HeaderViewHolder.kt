package com.example.advancedrv.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedrv.databinding.ItemHeaderBinding
import com.example.advancedrv.model.Item

class HeaderViewHolder constructor(
    internal val binding: ItemHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item.Header) {
        binding.header = item
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): HeaderViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemHeaderBinding.inflate(inflater, parent, false)
            return HeaderViewHolder(binding)
        }
    }
}
