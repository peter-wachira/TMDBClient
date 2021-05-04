package com.anushka.tmdbclient.domain

import com.anushka.tmdbclient.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun  execute():List<Movie>? = movieRepository.getMovies()


}