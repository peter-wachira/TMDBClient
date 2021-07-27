package com.droid.tmdbclient.data.repository.movie.datasource

import com.droid.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}