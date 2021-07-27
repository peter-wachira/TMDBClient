package com.droid.tmdbclient.domain.usecase

import com.droid.tmdbclient.data.model.movie.Movie
import com.droid.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}