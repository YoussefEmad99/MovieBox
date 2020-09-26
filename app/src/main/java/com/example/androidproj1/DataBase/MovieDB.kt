package com.example.androidproj1.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidproj1.Models.UI.FavMovieUI
import com.example.androidproj1.Models.UI.UIMovie

@Database(entities = [UIMovie::class, FavMovieUI::class],version = 1, exportSchema = false)
abstract class MovieDB: RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
    abstract fun getFavMovieDao(): FavMovieDao
    companion object {

        private var INSTANCE: MovieDB? = null
        fun getDatabase(context: Context): MovieDB {

            if (INSTANCE != null)
                return INSTANCE!!

            INSTANCE = Room.databaseBuilder(
                context.applicationContext, MovieDB::class.java, "Movie_DB"
            ).allowMainThreadQueries().build()

            return INSTANCE!!
        }
    }

}