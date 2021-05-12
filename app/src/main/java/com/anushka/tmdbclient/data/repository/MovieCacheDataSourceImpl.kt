package com.droid.tmdbclient.data.repository

import com.droid.tmdbclient.data.model.movie.Movie

class MovieCacheDataSourceImpl : MovieCacheDataSource{
    private  var movieList = ArrayList<Movie>()
    override suspend fun getMoviewsFromCache(): List<Movie> {
        return  movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}