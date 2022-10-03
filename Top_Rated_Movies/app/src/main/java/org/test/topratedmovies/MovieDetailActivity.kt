package org.test.topratedmovies

import androidx.appcompat.app.AppCompatActivity


private const val TAG = "MovieDetailActivity"
class MovieDetailActivity : AppCompatActivity() {}

/*
class DetailActivity : AppCompatActivity() {
    // variables we can use for the views
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Link the variables to the views in the xml
        mediaImageView = findViewById(R.id.mediaImage)
        titleTextView = findViewById(R.id.mediaTitle)
        bylineTextView = findViewById(R.id.mediaByline)
        abstractTextView = findViewById(R.id.mediaAbstract)

        // Get the extra (article data) from the intent from the Intent
        val article = intent.getSerializableExtra(ARTICLE_EXTRA) as Article

        // Set the title, byline, and abstract information from the article
        titleTextView.text = article.headline?.main
        bylineTextView.text = article.byline?.original
        abstractTextView.text = article.abstract

        // Load the media image
        Glide.with(this)
            .load(article.mediaImageUrl)
            .into(mediaImageView)
    }
}
*/