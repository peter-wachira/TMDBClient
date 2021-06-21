package com.droid.tmdbclient.data.repository.movie.datasourceimpl

import com.droid.tmdbclient.data.model.movie.Movie
import com.droid.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource


class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private  var movieList = ArrayList<Movie>()
    override suspend fun getMoviewsFromCache(): List<Movie> {
        return  movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}