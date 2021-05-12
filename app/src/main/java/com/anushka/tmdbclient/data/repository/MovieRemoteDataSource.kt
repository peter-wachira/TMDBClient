package com.anushka.tmdbclient.data.repository

import com.anushka.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun  getMovies(): Response<MovieList>
    
}