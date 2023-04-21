package com.softwarejourneys.tallersergio.model

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MoviesService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private suspend fun getMovies(): MovieResponse? {

        val moviesApiService = retrofit.create(MoviesServiceClient::class.java)
        val response = moviesApiService.getMovies("2a0d95646af171c0e4189b9c66819a91").body()

        Log.i("peliculas", "response Recibido:  $response")

        return response

    }

    suspend fun moviesDataBase(): List<MovieDB>?{

        var response = getMovies()

        Log.i("peliculas", "Movies DB recibio ${response?.results}")
        return response?.results

    }

    suspend fun moviesList(): List<Movie>? {
        var moviesDataBase= moviesDataBase()
        var moviesList= moviesDataBase?.map { it -> Movie(it.id,"https://image.tmdb.org/t/p/w500/"+it.posterPath,it.title,it.vote_count,it.adult) }

        Log.i("peliculas","peliculas enviadas service $moviesList")
        return moviesList

    }


}