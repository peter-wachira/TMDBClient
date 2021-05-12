package com.droid.tmdbclient.data.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.droid.tmdbclient.data.model.movie.Movie
import com.droid.tmdbclient.data.model.tvshow.TvShow

interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<TvShow>)

    @Query("DELETE FROM popular_tvshows ")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getMovies(): List<TvShow>
}