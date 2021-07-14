package com.droid.tmdbclient.data.repository.movie.datasourceimpl

import com.droid.tmdbclient.data.api.TMDBService
import com.droid.tmdbclient.data.model.movie.MovieList
import com.droid.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource

import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}