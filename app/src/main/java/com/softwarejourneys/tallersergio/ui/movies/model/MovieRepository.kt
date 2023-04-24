package com.softwarejourneys.tallersergio.ui.movies.model

class MovieRepository(private var dataBase: AppDatabase) {

 private val moviesService= MoviesService()

    val movieDao= dataBase.movieDao()




    private suspend fun getAllFromService():List<Movie>?{
        return moviesService.moviesList()
    }

    suspend fun getAllFromDatabase():List<Movie>{
        return movieDao.getAll()
    }

    suspend fun insertMoviesInDatabase(){

        var newMovies= getAllFromService()?: emptyList()
        var actualMovies= getAllFromDatabase()

        val commonId= actualMovies.map { it.id }.intersect(newMovies.map { it.id })
        newMovies=   newMovies.filterNot { commonId.contains(it.id) }


        movieDao.insertAll(newMovies)

        actualMovies= actualMovies.filterNot { commonId.contains(it.id) }

        movieDao.deleteMovies(actualMovies)
    }

    suspend fun updateMovie(movie:Movie){
        movieDao.updateMovie(movie)
    }


}