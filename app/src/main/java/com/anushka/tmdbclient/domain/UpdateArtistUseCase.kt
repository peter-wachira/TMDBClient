package com.anushka.tmdbclient.domain

import com.anushka.tmdbclient.data.model.artist.Artist

class UpdateArtistUseCase (private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtist()
}