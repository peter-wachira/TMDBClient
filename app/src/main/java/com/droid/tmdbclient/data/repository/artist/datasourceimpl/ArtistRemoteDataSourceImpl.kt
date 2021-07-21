package com.droid.tmdbclient.data.repository.artist.datasourceimpl


import ArtistRemoteDatasource
import com.droid.tmdbclient.data.api.TMDBService
import com.droid.tmdbclient.data.model.artist.ArtistList

import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}




