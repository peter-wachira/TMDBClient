package com.anushka.tmdbclient.domain

import com.anushka.tmdbclient.data.model.tvshow.TvShow

class UpdateTvShowUseCase (private val tvShowsRepository: TvShowsRepository){
    suspend fun execute():List<TvShow>? = tvShowsRepository.updateTvShows()

}