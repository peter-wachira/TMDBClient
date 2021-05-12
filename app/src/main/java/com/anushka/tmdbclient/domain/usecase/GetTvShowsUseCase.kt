package com.anushka.tmdbclient.domain.usecase

import com.anushka.tmdbclient.data.model.tvshow.TvShow
import com.anushka.tmdbclient.domain.repository.TvShowsRepository

class GetTvShowsUseCase (private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute():List<TvShow>? = tvShowsRepository.getTvShows()
}
