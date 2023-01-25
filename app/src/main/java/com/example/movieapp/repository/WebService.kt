package com.example.movieapp.repository

import com.example.movieapp.application.AppConstants
import com.example.movieapp.data.model.MovieList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//con esto creamos el webservice que va a ir al servidor a buscar la info de los gets/ tenemos retrofit que es la instancia que nos va a proporcional la base url el converter y build
interface WebService {

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(@Query("api_key") apìKey: String): MovieList //nos da un movielist y es una funcion suspendida porq no sabemos cuando el servidor nos va a dar esa informacion por eso necesitamos suspender hasta q nos la de

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apìKey: String):  MovieList

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apìKey: String): MovieList

}

object RetrofitClient {

    //con lazy solo inicilizara la variable webService cuando la vayamos a ejecutar, no antes
    val webService by lazy {

        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())) //para que toda la informacion q este json la convertimos al objeto movie
            .build().create(WebService::class.java) //para generar la istancia de retrofit

    }
}