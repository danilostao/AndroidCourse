package com.example.movieapp.repository

import com.example.movieapp.data.local.InternetCheck
import com.example.movieapp.data.local.LocalMovieDataSource
import com.example.movieapp.data.model.MovieList
import com.example.movieapp.data.model.toMovieEntity
import com.example.movieapp.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(private val dataSourceRemote: RemoteMovieDataSource,
                          private val dataSourceLocal: LocalMovieDataSource
                          ): MovieRepository {

    override suspend fun getUpComingMovies(): MovieList{
        return if(InternetCheck.isNetworkAvailable()){
            //si tenemos internet guardamos los datos del servidor y lo mostramos
            dataSourceRemote.getUpcomingMovies().results.forEach {movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
            }
            dataSourceLocal.getUpcomingMovies()
        }else{
            //si no tenmos internet mostramos los ultimos guardados
            dataSourceLocal.getUpcomingMovies()
        }

    }

    override suspend fun getTopRatedMovies(): MovieList{
        return if(InternetCheck.isNetworkAvailable()){
            //si tenemos internet guardamos los datos del servidor y lo mostramos
            dataSourceRemote.getTopRatedMovies().results.forEach {movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
            }
            dataSourceLocal.getTopRatedMovies()
        }else{
            //si no tenmos internet mostramos los ultimos guardados
            dataSourceLocal.getTopRatedMovies()
        }
    }

    override suspend fun getPopularMovies(): MovieList {
        return if(InternetCheck.isNetworkAvailable()){
            //si tenemos internet guardamos los datos del servidor y lo mostramos
            dataSourceRemote.getPopularMovies().results.forEach {movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
            }
            dataSourceLocal.getPopularMovies()
        }else{
            //si no tenmos internet mostramos los ultimos guardados
            dataSourceLocal.getPopularMovies()
        }
    }
}