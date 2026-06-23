package com.example.advancedrv.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:backgroundColor")
fun setBackgroundColor(view: View, color: Int) {
    view.setBackgroundColor(color)
}
