package com.droid.tmdbclient.domain.usecase

import com.droid.tmdbclient.data.model.tvshow.TvShow
import com.droid.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}