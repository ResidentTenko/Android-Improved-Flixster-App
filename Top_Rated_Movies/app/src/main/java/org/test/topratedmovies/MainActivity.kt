package org.test.topratedmovies

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.test.topratedmovies.databinding.ActivityMainBinding
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONException


/**
 * Project Steps:
 * 1. Async and grab the JSON values
 * 2. Serialize the JSON values and convert them into Kotlin data types
 * 3. Feed that into the data model class
 * 4. Feed that value into the adapter -
 * 5. The OnBind view holder populates the (View) XML fields with the data model values
 */


fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private const val TAG = "MainActivity/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val TOP_RATED_URL =
    "https://api.themoviedb.org/3/movie/top_rated?api_key=${SEARCH_API_KEY}"

class MainActivity : AppCompatActivity() {
    /**
     * Note we are using the data class Articles
     * Not the data  class SearchNewsResponse or BaseResponse
     * Those two are just to allow us to dig in to get the JSON articles for serialization
     */
    private val movies = mutableListOf<Movie>()
    private lateinit var moviesRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        moviesRecyclerView = findViewById(R.id.movies)

        val movieAdapter = TopRatedMovieAdapter(this, movies)
        moviesRecyclerView.adapter = movieAdapter

        moviesRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            moviesRecyclerView.addItemDecoration(dividerItemDecoration)
        }

    }
}