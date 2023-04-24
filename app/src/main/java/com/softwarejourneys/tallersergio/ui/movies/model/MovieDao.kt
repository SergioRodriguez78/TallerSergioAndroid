package com.softwarejourneys.tallersergio.ui.movies.model

import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    suspend fun getAll(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAll(movies:List<Movie>)
    @Query("DELETE FROM Movie")
    suspend fun deleteAll()
    @Update
    suspend fun updateMovie(movie:Movie)
    @Delete
    suspend fun deleteMovies(movies:List<Movie>)

}