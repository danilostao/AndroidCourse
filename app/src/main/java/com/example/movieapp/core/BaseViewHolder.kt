package com.example.movieapp.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: T) //a la imagen de la pelicula con este bind le pondremos la imagen

}