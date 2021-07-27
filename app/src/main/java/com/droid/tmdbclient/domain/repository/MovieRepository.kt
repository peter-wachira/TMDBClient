package com.droid.tmdbclient.domain.repository

import com.droid.tmdbclient.data.model.movie.Movie


interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}