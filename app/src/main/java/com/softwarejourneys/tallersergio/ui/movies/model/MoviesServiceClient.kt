package com.softwarejourneys.tallersergio.ui.movies.model

import com.softwarejourneys.tallersergio.ui.movies.UiState
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServiceClient {

    @GET("movie/top_rated")
   suspend fun getMovies(@Query("api_key") apiKey:String): Response<MovieResponse>


}