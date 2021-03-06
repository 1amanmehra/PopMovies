package com.example.android.popmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;

//Details of movie to be displayed by this detail activity.

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        TextView mTitle = (TextView) findViewById(R.id.title);
        ImageView mPoster = (ImageView) findViewById(R.id.poster);
        TextView mVote = (TextView) findViewById(R.id.vote_average);
        TextView mDate = (TextView) findViewById(R.id.release_date);
        TextView mOverview = (TextView) findViewById(R.id.overview);
        String imgAddress;
        Intent intentThatStartedThisActivity = getIntent();


        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra("Content")) {
                Movies movie = intentThatStartedThisActivity.getParcelableExtra("Content");
                mTitle.setText(movie.getTitle());
                mVote.setText(movie.getVoteAverage());
                mDate.setText(movie.getReleaseDate());
                mOverview.setText(movie.getOverview());
                imgAddress = movie.getMoviePoster();
                URL newUrl = NetworkUtils.buildImageUrl(imgAddress);
                Picasso.with(this).load(newUrl.toString()).into(mPoster);
            }
        }
    }
}
