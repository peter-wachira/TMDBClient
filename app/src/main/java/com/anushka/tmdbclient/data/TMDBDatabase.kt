package com.anushka.tmdbclient.data

import androidx.room.Database
import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow:: class, Artist::class], version = 1,exportSchema = false)
abstract class TMDBDatabase {
    abstract fun  movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract  fun tvshowDao(): TvShowDao
}