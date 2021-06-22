package com.droid.tmdbclient.data.repository.movie.datasourceimpl

import com.droid.tmdbclient.data.api.TMDBService
import com.droid.tmdbclient.data.model.movie.MovieList
import com.droid.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource

import retrofit2.Response

class MovieRemoteDataSourceImpl (private val tmdbService: TMDBService, private val apiKey: String):
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}