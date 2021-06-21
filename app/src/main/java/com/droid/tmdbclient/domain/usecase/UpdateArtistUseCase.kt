package com.droid.tmdbclient.domain.usecase

import com.droid.tmdbclient.data.model.artist.Artist
import com.droid.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase (private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtist()
}