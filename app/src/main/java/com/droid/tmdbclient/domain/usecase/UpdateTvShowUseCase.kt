package com.droid.tmdbclient.domain.usecase

import com.droid.tmdbclient.data.model.tvshow.TvShow
import com.droid.tmdbclient.domain.repository.TvShowsRepository

class UpdateTvShowUseCase (private val tvShowsRepository: TvShowsRepository){
    suspend fun execute():List<TvShow>? = tvShowsRepository.updateTvShows()

}