package com.example.movieapp.core

sealed class Resource<out T>{

    class Loading<out T>: Resource<T>()
    //Estado 1
    data class Success<out T>(val data: T): Resource<T>()
    //Estado 2
    data class Failure(val exception: Exception): Resource<Nothing>() //devolvemos un generico

}