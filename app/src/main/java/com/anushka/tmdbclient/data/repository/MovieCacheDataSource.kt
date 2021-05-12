package com.anushka.tmdbclient.data.repository

import com.anushka.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource  {
    suspend fun getMoviewsFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)

}