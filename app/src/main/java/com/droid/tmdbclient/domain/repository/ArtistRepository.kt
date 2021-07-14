package com.droid.tmdbclient.domain.repository

import com.droid.tmdbclient.data.model.artist.Artist


interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}