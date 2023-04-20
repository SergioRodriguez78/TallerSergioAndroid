package com.softwarejourneys.tallersergio.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softwarejourneys.tallersergio.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MoviesViewModel : ViewModel() {

    private var _movies = MutableLiveData<UiState>()
    val movie: LiveData<UiState> = _movies


    fun getAllMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                _movies.postValue(UiState.ListMovies(movies/*Aqui iria una funcion que recibe la data de la BD*/))

            }
        }
    }

    fun getFavoriteMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val moviesTemporal = movies/*Aqui iria una funcion que recibe la data de la BD*/

                val favoriteMovies: List<Movie> =
                    moviesTemporal.filter { it.favorite }
                _movies.postValue(UiState.FavoriteMovies(favoriteMovies))

            }
        }

    }

    fun changeStateFavorite(idMovie: Int, favorite: Boolean, isFavoriteFragment:Boolean) {
        val movie = movies.filter { movie: Movie -> movie.id == idMovie }
        movie[0].favorite = favorite

        if(isFavoriteFragment){
        _movies.value = UiState.FavoriteMovies(movies = movies.filter { it.favorite })
        }
       //_movies.value = UiState.ListMovies(movies = movies)
    }


}

sealed class UiState {
    class ListMovies(val movies: List<Movie>) : UiState()
    class FavoriteMovies(val movies: List<Movie>) : UiState()

}

val movies = listOf(
    Movie(
        1,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "Batman",
        120,
        true
    ),
    Movie(
        2,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "spiderman",
        70,
        false
    ),
    Movie(
        3,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "joker",
        40,
        false
    ),
    Movie(
        4,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "señor de los anillos",
        240,
        false
    ),
    Movie(
        5,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "adsfa",
        80,
        false
    ),
    Movie(
        6,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "mackbook",
        456,
        false
    ),
    Movie(
        7,
        "https://www.codingpizza.com/wp-content/uploads/2018/12/GLIDE-CDA9-IG.png",
        "joker",
        40,
        false
    ),
    Movie(
        8,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "Batman 2",
        12320,
        true
    ),
    Movie(
        9,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "spiderman 2",
        70234,
        true
    ),
    Movie(
        10,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "joker 2",
        40423,
        true
    ),
    Movie(
        11,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "señor de los anillos 2",
        242430,
        true
    ),
    Movie(
        12,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "adsfa 2",
        80243,
        true
    ),
    Movie(
        13,
        "https://media.revistagq.com/photos/63edfa0ecf53bfbacf6f6580/master/pass/spider-man-4-tom-holland.jpg",
        "mackbook 2",
        452436,
        true
    ),
    Movie(
        14,
        "https://www.codingpizza.com/wp-content/uploads/2018/12/GLIDE-CDA9-IG.png",
        "joker 2",
        42340,
        true

    )
)
