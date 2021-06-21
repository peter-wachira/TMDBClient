
import com.droid.tmdbclient.data.model.artist.ArtistList
import com.droid.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun  getArtists(): Response<ArtistList>

}