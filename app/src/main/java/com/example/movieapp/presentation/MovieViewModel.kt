package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.movieapp.core.Resource
import com.example.movieapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow

//el ciclo el vida y el viewmodel trabajan juntos para garantizar al usuario que los datos son los ultimos q se han actualizado
//
class MovieViewModel(private val repo: MovieRepository): ViewModel() {

    //este metodo se comunica con el repositorio. liveData
    fun fetchMainScreenMovies() = liveData(Dispatchers.IO){
        //3 tipos de estados, hemos creado el paquete Resource que contredrá una clase que almacenerá esos tres estados.
        //Estado de carga, antes de mostrar la informacion al usuario esta yendo a buscarla al servidor
        //Estado de exito, que nos traera esta información del servidor
        //Estado de fallo, que si falla le dará un mensaje al usuario

        emit(Resource.Loading())
        try {
            emit(Resource.Success(Triple(repo.getUpComingMovies(),repo.getTopRatedMovies(), repo.getPopularMovies()))) //con tiple llamamos a 3 si queremos 4
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    } //dispacher.io es el hilo para ejectuar tareas en segundo plano (como el suspend que hemos creado anteriormente


}

class MovieViewModelFactory(private  val repo: MovieRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}

//data class NTuple4<T1, T2, T3, T4>(val t1: T1, val t2: T2, val t3: T3, val t4: T4) //con esta clase podemos devolver 5 objetos distintos y luego lo ponemos NTuple4 en la linea 20