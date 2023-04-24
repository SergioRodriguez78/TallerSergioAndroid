package com.softwarejourneys.tallersergio.ui.movies

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.softwarejourneys.tallersergio.ui.movies.model.AppDatabase
import com.softwarejourneys.tallersergio.ui.movies.model.Movie
import com.softwarejourneys.tallersergio.ui.movies.model.MovieRepository
import com.softwarejourneys.tallersergio.ui.movies.model.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep


class MoviesViewModel : ViewModel() {

    private var _movies = MutableLiveData<UiState>()
    val movie: LiveData<UiState> = _movies
     var movieList: List<Movie>? = null
    private lateinit var movieRepository:MovieRepository
    

    fun initDatabase(context:Context){
        movieRepository= MovieRepository(
            dataBase= Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase").build()
        )
    }

    suspend fun giveMovies()=  movieRepository.getAllFromDatabase()
    fun getAllMoviesFirstTime() {
        viewModelScope.launch(Dispatchers.IO) {

                movieRepository.insertMoviesInDatabase()

            movieList= movieRepository.getAllFromDatabase()
        }
    }

    fun getMovies() {
        while (movieList == null) {
            sleep(50)
        }
        movieList?.let {
            _movies.value = UiState.ListMovies(it)
        }
    }

    fun getFavoriteMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val moviesTemporal = movieList

                val favoriteMovies: List<Movie>? =
                    moviesTemporal?.filter { it.favorite }
                Log.i("peliculas", "peliculas favoritas enviadas $movieList")
                _movies.postValue(UiState.FavoriteMovies(favoriteMovies ?: listOf()))

            }
        }

    }

    fun changeStateFavorite(idMovie: Int, favorite: Boolean, isFavoriteFragment:Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieList?.filter { movie: Movie -> movie.id == idMovie }
            movie?.get(0)?.favorite = favorite
            movie?.get(0)?.let { movieRepository.updateMovie(it) }

            if(isFavoriteFragment){
                _movies.postValue(movieList.let { UiState.FavoriteMovies(movies = it?.filter { it.favorite } ?: listOf()) })
            }
        }

       //_movies.value = UiState.ListMovies(movies = movies)
    }






}

sealed class UiState {
    class ListMovies(val movies: List<Movie>) : UiState()
    class FavoriteMovies(val movies: List<Movie>) : UiState()

    class films(val movies: List<Movie>?):UiState()

}
