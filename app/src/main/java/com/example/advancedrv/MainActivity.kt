package com.example.advancedrv

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedrv.adapter.ItemAdapter
import com.example.advancedrv.databinding.ActivityMainBinding
import com.example.advancedrv.model.Item

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        binding.fabRefresh.setOnClickListener { refreshData() }

        loadInitialData()
    }

    private fun setupRecyclerView() {
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    Item.TYPE_HEADER -> 2
                    else -> 1
                }
            }
        }
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun loadInitialData() {
        val items = listOf(
            Item.Header(1, "Angka Ganjil", Color.parseColor("#1976D2")),
            Item.DataItem(2, "Satu", generateColor(), 1),
            Item.DataItem(3, "Tiga", generateColor(), 3),
            Item.DataItem(4, "Lima", generateColor(), 5),
            Item.DataItem(5, "Tujuh", generateColor(), 7),

            Item.Header(6, "Angka Genap", Color.parseColor("#388E3C")),
            Item.DataItem(7, "Dua", generateColor(), 2),
            Item.DataItem(8, "Empat", generateColor(), 4),
            Item.DataItem(9, "Enam", generateColor(), 6),

            Item.Header(10, "Warna Hangat", Color.parseColor("#F57C00")),
            Item.DataItem(11, "Merah", Color.parseColor("#E53935"), 0),
            Item.DataItem(12, "Kuning", Color.parseColor("#FDD835"), 0),
            Item.DataItem(13, "Oranye", Color.parseColor("#FB8C00"), 0),

            Item.Header(14, "Warna Dingin", Color.parseColor("#7B1FA2")),
            Item.DataItem(15, "Biru", Color.parseColor("#1E88E5"), 0),
            Item.DataItem(16, "Hijau", Color.parseColor("#43A047"), 0),
            Item.DataItem(17, "Ungu", Color.parseColor("#8E24AA"), 0),
        )
        adapter.submitList(items)
    }

    private fun refreshData() {
        val newItems = listOf(
            Item.Header(1, "Angka Ganjil", Color.parseColor("#1976D2")),
            Item.DataItem(2, "Satu", generateColor(), 1),
            Item.DataItem(3, "Tiga", generateColor(), 3),
            Item.DataItem(4, "Lima", generateColor(), 5),
            Item.DataItem(5, "Tujuh", generateColor(), 7),

            Item.Header(6, "Angka Genap", Color.parseColor("#388E3C")),
            Item.DataItem(7, "Dua", generateColor(), 2),
            Item.DataItem(8, "Empat", generateColor(), 4),

            Item.Header(10, "Warna Hangat", Color.parseColor("#F57C00")),
            Item.DataItem(11, "Merah", Color.parseColor("#E53935"), 0),
            Item.DataItem(12, "Kuning", Color.parseColor("#FDD835"), 0),

            Item.Header(14, "Warna Dingin", Color.parseColor("#7B1FA2")),
            Item.DataItem(15, "Biru", Color.parseColor("#1E88E5"), 0),
            Item.DataItem(16, "Hijau", Color.parseColor("#43A047"), 0),

            Item.Header(18, "Warna Pastel (Baru)", Color.parseColor("#FF6F00")),
            Item.DataItem(19, "Pink", Color.parseColor("#F48FB1"), 0),
            Item.DataItem(20, "Mint", Color.parseColor("#80CBC4"), 0),
        )
        adapter.submitList(newItems)
    }

    private var colorIndex = 0
    private val colors = listOf(
        Color.parseColor("#E53935"),
        Color.parseColor("#D81B60"),
        Color.parseColor("#8E24AA"),
        Color.parseColor("#5E35B1"),
        Color.parseColor("#3949AB"),
        Color.parseColor("#1E88E5"),
        Color.parseColor("#039BE5"),
        Color.parseColor("#00ACC1"),
        Color.parseColor("#00897B"),
        Color.parseColor("#43A047"),
    )

    private fun generateColor(): Int {
        val c = colors[colorIndex]
        colorIndex = (colorIndex + 1) % colors.size
        return c
    }
}
