package com.droid.tmdbclient.data.repository

import android.util.Log
import com.droid.tmdbclient.data.model.artist.Artist
import com.droid.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.droid.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.droid.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.droid.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return  getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        return artistList
    }

    suspend fun getMoviesFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
            if (artistList.isNotEmpty()) {
                return artistList
            } else {
                artistList = getArtistsFromAPI()
                artistLocalDataSource.saveArtistsToDB(artistList)
            }
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }
}