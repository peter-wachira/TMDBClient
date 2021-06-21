package com.droid.tmdbclient.data.repository

import com.droid.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun  getMoviesFromDB(): List<Movie>
    suspend fun  saveMoviesToDB(movies: List<Movie>)
    suspend fun  clearAll()
}