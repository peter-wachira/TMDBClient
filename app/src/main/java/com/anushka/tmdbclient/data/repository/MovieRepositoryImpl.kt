package com.droid.tmdbclient.data.repository

import android.util.Log
import com.anushka.tmdbclient.data.repository.MovieRemoteDataSource
import com.droid.tmdbclient.data.model.movie.Movie
import com.droid.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl (
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
        ) : MovieRepository{
    override suspend fun getMovies(): List<Movie>? {
        return  getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun  getMoviesFromAPI(): List<Movie>{
        lateinit  var movieList: List<Movie>
        try {
          val response  = movieRemoteDataSource.getMovies()
          val body = response.body()
            if (body != null ){
                movieList = body.movies
            }
        }catch (exception: Exception){
            Log.i("MYTAG",exception.message.toString() )
        }

        if(movieList.isNotEmpty()){
            return  movieList
        }
        else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie>{
        lateinit  var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception: Exception){
            Log.i("MYTAG",exception.message.toString())
            if (movieList.isNotEmpty()){
                return movieList
            }else{
                movieList = getMoviesFromAPI()
                movieLocalDataSource.saveMoviesToDB(movieList)
            }

        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>
    {
        lateinit  var movieList: List<Movie>

        try {
           movieList = movieCacheDataSource.getMoviewsFromCache()
        }catch (exception: Exception){
            Log.i("MYTAG",exception.message.toString() )
        }

        if(movieList.isNotEmpty()){
            return  movieList
        }
        else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }
}