package com.example.movieapp.application

//objet funciona como un singleton entonces, nos permite que siempre que usemos appConstants va usar la misma instancia siempre y lo crea solo una vez
object AppConstants {

    //API
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "6a40557aacf926818838996b834f5831"

}