package com.example.pazaramamovieapp.data.mapper

import com.example.pazaramamovieapp.data.dto.MovieDetailDto
import com.example.pazaramamovieapp.domain.model.MovieDetail

fun MovieDetailDto.toMovieDetail(): MovieDetail {
    return MovieDetail(
        director = director,
        genre = genre,
        imdbID = imdbID,
        imdbRating = imdbRating,
        language = language,
        plot = plot,
        poster = poster,
        production = production,
        released = released,
        runtime = runtime,
        title = title,
        type = type,
        year = year
    )
}