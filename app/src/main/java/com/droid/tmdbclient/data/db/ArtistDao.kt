package com.droid.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.droid.tmdbclient.data.model.artist.Artist


@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies: List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllTvShows(artistList: List<Artist>)

    @Query("SELECT * FROM popular_artist")
    suspend fun getTvShows(): List<Artist>
}