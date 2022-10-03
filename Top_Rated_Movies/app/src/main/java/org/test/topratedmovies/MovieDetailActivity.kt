package org.test.topratedmovies

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "MovieDetailActivity"

class MovieDetailActivity : AppCompatActivity() {
    // variables we can use for the views

    private lateinit var movieImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var overviewTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        // Link the variables to the views in the xml
        movieImageView = findViewById(R.id.movieBackdrop)
        titleTextView = findViewById(R.id.movieTitle)
        dateTextView = findViewById(R.id.movieDate)
        overviewTextView = findViewById(R.id.movieOverview)

        // Get the extra (article data) from the intent from the Intent
        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        // Set the title, date, and overview information from the movie
        titleTextView.text = movie.original_title
        dateTextView.text = movie.release_date
        overviewTextView.text = movie.overview

        Glide.with(this)
            .load(movie.movieBackdropUrl)
            .into(movieImageView)
    }
}