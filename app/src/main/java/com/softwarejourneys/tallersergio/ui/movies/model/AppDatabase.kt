package com.softwarejourneys.tallersergio.ui.movies.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract  fun movieDao(): MovieDao


}