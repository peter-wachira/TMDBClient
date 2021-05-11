package com.anushka.tmdbclient.domain

import com.anushka.tmdbclient.data.model.artist.Artist
import com.anushka.tmdbclient.data.model.movie.Movie

class GetArtistUsecase (private val artistRepository: ArtistRepository) {

    suspend fun  execute(): List<Artist>? = artistRepository.getArtists()

}