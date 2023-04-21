package com.softwarejourneys.tallersergio.model

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAll(): List<Movie>
}