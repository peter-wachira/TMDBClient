package com.anushka.tmdbclient.data.repository

import android.util.Log
import com.anushka.tmdbclient.data.model.movie.Movie
import com.anushka.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl (
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
        ) : MovieRepository{
    override suspend fun getMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateMovies(): List<Movie>? {
        TODO("Not yet implemented")
    }

    suspend fun  getMoviesFromAPI(): List<Movie>{
        lateinit  var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body!= null){
                movieList = body.movies
            }

        }catch (exception: Exception){
            Log.i("MYTAG",exception.message.toString() )
        }
        return movieList
    }

}