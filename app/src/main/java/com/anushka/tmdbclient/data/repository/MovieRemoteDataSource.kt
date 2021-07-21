package com.anushka.tmdbclient.data.repository

import com.droid.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun  getMovies(): Response<MovieList>
    
}