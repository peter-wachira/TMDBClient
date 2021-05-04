package com.anushka.tmdbclient.data.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshow.TvShow

interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<TvShow>)

    @Query("DELETE FROM popular_tvshows ")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getMovies(movies: List<TvShow>)
}