package com.droid.tmdbclient.data.repository.artist.datasource

import com.droid.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
   suspend fun getArtists(): Response<ArtistList>
}