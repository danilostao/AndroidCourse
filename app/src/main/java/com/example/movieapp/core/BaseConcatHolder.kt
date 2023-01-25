package com.example.movieapp.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseConcatHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(adapter: T) //aqui ponemos adapter en vez item porq asi no generamos confusiones xd

}