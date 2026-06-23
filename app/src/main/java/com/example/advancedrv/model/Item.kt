package com.example.advancedrv.model

sealed class Item {
    abstract val id: Int
    abstract val type: Int

    data class Header(
        override val id: Int,
        val title: String,
        val color: Int
    ) : Item() {
        override val type: Int = TYPE_HEADER
    }

    data class DataItem(
        override val id: Int,
        val label: String,
        val color: Int,
        val value: Int
    ) : Item() {
        override val type: Int = TYPE_DATA
    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_DATA = 1
    }
}
