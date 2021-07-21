package com.droid.tmdbclient.data.db

import androidx.room.Database
import com.droid.tmdbclient.data.model.artist.Artist
import com.droid.tmdbclient.data.model.movie.Movie
import com.droid.tmdbclient.data.model.tvshow.TvShow


@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 3,
    exportSchema = false
)
abstract class TMDBDatabase {
    abstract fun  movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract  fun tvshowDao(): TvShowDao
}