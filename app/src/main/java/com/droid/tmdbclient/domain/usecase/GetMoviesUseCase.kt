package com.droid.tmdbclient.domain.usecase

import com.droid.tmdbclient.domain.repository.MovieRepository
import com.droid.tmdbclient.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun  execute():List<Movie>? = movieRepository.getMovies()


}