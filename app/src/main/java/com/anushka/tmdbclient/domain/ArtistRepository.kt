package com.anushka.tmdbclient.domain

import com.anushka.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists():List<Artist>?
    suspend fun updateArtist():List<Artist>?

}