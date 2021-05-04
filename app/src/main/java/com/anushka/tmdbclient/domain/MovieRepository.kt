package com.anushka.tmdbclient.domain

import com.anushka.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun  updateMovies():List<Movie>?

}