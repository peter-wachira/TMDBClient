package com.anushka.tmdbclient.domain

import com.anushka.tmdbclient.data.model.tvshow.TvShow

class GetTvShowsUseCase (private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute():List<TvShow>? = tvShowsRepository.getTvShows()
}
