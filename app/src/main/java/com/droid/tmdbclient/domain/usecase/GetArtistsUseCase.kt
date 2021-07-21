package com.droid.tmdbclient.domain.usecase

import com.droid.tmdbclient.data.model.artist.Artist
import com.droid.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()

}