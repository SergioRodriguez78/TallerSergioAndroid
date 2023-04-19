package com.softwarejourneys.tallersergio.viewModel

import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.*
import com.softwarejourneys.tallersergio.model.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class MoviesViewModel() : ViewModel() {

    var movies= listOf<Movies>()

    fun getAllMovies(){


        viewModelScope.launch{
            withContext(Dispatchers.IO){
                val movies= Movies.moviesDefault
                Log.i("ViewM","Estoy recibiendo ${movies}")

            }

        }
        Log.i("ViewM","Estoy enviando ${movies}")


    }

}

