package com.anushka.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.artist.ArtistList
import com.anushka.tmdbclient.data.model.movie.Movie

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllTvShows(artistList: List<Artist>)

    @Query("SELECT * FROM popular_artist")
    suspend fun getTvShows(): List<Artist>
}