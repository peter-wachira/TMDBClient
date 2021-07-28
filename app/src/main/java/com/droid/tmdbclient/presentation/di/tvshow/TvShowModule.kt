package com.droid.tmdbclient.presentation.di.tvshow

import com.droid.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.droid.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.droid.tmdbclient.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}