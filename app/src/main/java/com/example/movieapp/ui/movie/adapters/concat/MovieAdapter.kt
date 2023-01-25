package com.example.movieapp.ui.movie.adapters.concat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.core.BaseViewHolder
import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.model.MovieList
import com.example.movieapp.databinding.MovieItemBinding

//ADAPTADOR PRINCIPAL

class MovieAdapter (private val movieList: List<Movie>, private val itemClickListener: OnMovieClickListener): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(movie: Movie)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener{
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION  }//obtendremos la posicion de cada elemento q obtenemos en vista
                ?: return@setOnClickListener
            itemClickListener.onMovieClick(movieList[position])
        }

        return holder //nos devuelve este metodo la vista entera de cada uno de los elementos de  como se va a ver en la lista
    }

    override fun getItemCount(): Int= movieList.size //muestra la cantidad de itemos que tiene la lista


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(holder){
           is MoviesViewHolder -> holder.bind(movieList[position])
       }
    }

    private inner class MoviesViewHolder(val binding: MovieItemBinding, val context: Context): BaseViewHolder<Movie>(binding.root){
        override fun bind(item: Movie){
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.poster_path}").centerCrop().into(binding.imgMovie)
        }
    }

}