package com.anushka.tmdbclient.data.repository

import com.anushka.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun  getMoviesFromDB(): List<Movie>
    suspend fun  saveMoviesToDB(movies: List<Movie>)
    suspend fun  clearAll()
}