package com.softwarejourneys.tallersergio.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softwarejourneys.tallersergio.model.Movie
import com.softwarejourneys.tallersergio.model.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep


class MoviesViewModel : ViewModel() {

    private var _movies = MutableLiveData<UiState>()
    val movie: LiveData<UiState> = _movies
    private var moviesss: List<Movie>? = null

    fun getAllMoviesFirstTime() {
        viewModelScope.launch(Dispatchers.IO) {
            moviesss = MoviesService().moviesList()
        }
    }

    fun getMovies() {
        while (moviesss == null) {
            sleep(50)
        }
        moviesss?.let {
            _movies.value = UiState.ListMovies(it)
        }
    }

    fun getFavoriteMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val moviesTemporal = moviesss

                val favoriteMovies: List<Movie>? =
                    moviesTemporal?.filter { it.favorite }
                Log.i("peliculas", "peliculas favoritas enviadas $moviesss")
                _movies.postValue(UiState.FavoriteMovies(favoriteMovies ?: listOf()))

            }
        }

    }

    fun changeStateFavorite(idMovie: Int, favorite: Boolean, isFavoriteFragment:Boolean) {
        val movie = moviesss?.filter { movie: Movie -> movie.id == idMovie }
        movie?.get(0)?.favorite = favorite

        if(isFavoriteFragment){
        _movies.value = moviesss.let { UiState.FavoriteMovies(movies = it?.filter { it.favorite } ?: listOf()) }
        }
       //_movies.value = UiState.ListMovies(movies = movies)
    }






}

sealed class UiState {
    class ListMovies(val movies: List<Movie>) : UiState()
    class FavoriteMovies(val movies: List<Movie>) : UiState()

    class films(val movies: List<Movie>?):UiState()

}
