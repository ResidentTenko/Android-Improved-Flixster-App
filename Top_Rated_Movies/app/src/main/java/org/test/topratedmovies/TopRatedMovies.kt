package org.test.topratedmovies

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A nested JSON contains different types of objects
 * A list of nested JSON contains a list of the same type of objects
 * response has docs and meta which are two different types of JSON objects
 * headline has multiple JSON objects but they are all different types so it is nested
 * docs has lists of articles (the same model type - even if each article is different)
 * multimedia has lists of multimedia sources (the same model type)
 */

/**
 * The point of all this is to create a serialized data model
 * By serializing we break down complex JSON into traditional data types
 * such as String, arrays, int, double, etc
 * After digging into each complex JSON layer by layer
 */

// results is a list of JSON objects called Movies
@Keep
@Serializable
data class TopRatedResults(
    @SerialName("results")
    // results is of type list<Movies>
    val results: List<Movie>?
    )

// A movie contains traditional kotlin data types and a list of JSON objects
// Our main class that we will get by digging into response and into docs
@Keep
@Serializable
data class Movie(
    // traditional Kotlin String data type
    @SerialName("original_title")
    val original_title: String?,
    // traditional Kotlin String data type
    @SerialName("overview")
    val overview: String?,
    @SerialName("poster_path")
    val poster_path: String?,
    @SerialName("backdrop_path")
    val backdrop_path: String?,
    @SerialName("release_date")
    val release_date: String?,
): java.io.Serializable {
    val moviePosterUrl = "https://image.tmdb.org/t/p/w500${poster_path}"
    val movieBackdropUrl = "https://image.tmdb.org/t/p/w500${backdrop_path}"
}