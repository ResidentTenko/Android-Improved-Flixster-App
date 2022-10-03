package org.test.topratedmovies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MovieAdapter"

class TopRatedMovieAdapter (private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<TopRatedMovieAdapter.MovieViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movies_top_rated, parent, false)
        return MovieViewHolder(view)
    }

    // populate the xml with values from the data model
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // get the individual article from our list of articles,
        // and set the UI for it using our helper method:
        val movie = movies[position]
        // pass the movie to the bind helper function
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        // create our variables and link to the xml file
        private val posterView = itemView.findViewById<ImageView>(R.id.moviePoster)
        private val titleTextView = itemView.findViewById<TextView>(R.id.movieTitle)
        private val dateTextView = itemView.findViewById<TextView>(R.id.movieDate)
        private val overviewTextView = itemView.findViewById<TextView>(R.id.movieOverview)


        // assign an onclick listener to the view
        init {
            itemView.setOnClickListener(this)
        }

        //  Helper method that will help us set up the onBindViewHolder method.
        fun bind(movie: Movie) {
            // dig down into the data model and assign values to the views using dot properties
            titleTextView.text = movie.original_title
            dateTextView.text = movie.release_date
            overviewTextView.text = movie.overview


            // load the image view of the recycler view with the movie poster url
            Glide.with(context)
                .load(movie.moviePosterUrl)
                .into(posterView)
        }

        /**
         *We can create an Intent, using the current context,
         * and the Class that we are navigating to.
         * We can use .putExtra to pass along the article,
         * with the first argument being the key for the data, and the next being article itself.
         * We can then call startActivity with the current context,
         * using the intent as its parameter.
         */

        override fun onClick(v: View?) {
            // Get selected movie position
            val movie = movies[absoluteAdapterPosition]
            //  Navigate to Details screen and pass selected movie to the details screen
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }

    }
}