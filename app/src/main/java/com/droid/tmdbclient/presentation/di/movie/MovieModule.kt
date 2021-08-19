package com.droid.tmdbclient.presentation.di.movie

import com.droid.tmdbclient.domain.usecase.GetMoviesUseCase
import com.droid.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.droid.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}