package com.droid.tmdbclient.data.repository.artist.datasourceimpl

import ArtistRemoteDataSource
import com.droid.tmdbclient.data.api.TMDBService
import com.droid.tmdbclient.data.model.artist.ArtistList
import com.droid.tmdbclient.data.model.movie.MovieList
import com.droid.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource

import retrofit2.Response

class ArtistRemoteDataSourceImpl (private val tmdbService: TMDBService, private val apiKey: String):
    ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }

}