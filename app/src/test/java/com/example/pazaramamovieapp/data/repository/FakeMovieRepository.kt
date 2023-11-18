package com.example.pazaramamovieapp.data.repository

import com.example.pazaramamovieapp.domain.model.Movie
import com.example.pazaramamovieapp.domain.model.MovieDetail
import com.example.pazaramamovieapp.domain.repository.MovieRepository
import com.example.pazaramamovieapp.util.Resource
import kotlinx.coroutines.delay

class FakeMovieRepository : MovieRepository {
    var isReturnNetworkError = false
    override suspend fun getMovies(searchQuery: String): Resource<List<Movie>> {
        delay(1000)
        return if (isReturnNetworkError) {
            Resource.Error("Error", null)
        } else {
            Resource.Success(
                listOf(
                    Movie("Title1", "year", "imdbId", "Type1", "poster"),
                )
            )
        }
    }

    override suspend fun getMovieDetail(imdbID: String): Resource<MovieDetail> {
        delay(1000)
        return if (isReturnNetworkError) {
            Resource.Error("Error", null)
        } else {
            Resource.Success(
                MovieDetail(
                    "Genre",
                    "imdbId",
                    4.7f,
                    "6.5",
                    "plot",
                    "poster",
                    "released",
                    "120 min",
                    "title"
                )
            )
        }
    }
}