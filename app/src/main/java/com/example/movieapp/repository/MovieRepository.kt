package com.example.movieapp.repository

import com.example.movieapp.data.model.MovieList

interface MovieRepository {
    suspend fun getUpComingMovies(): MovieList //nos da un movielist y es una funcion suspendida porq no sabemos cuando el servidor nos va a dar esa informacion por eso necesitamos suspender hasta q nos la de
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList

}