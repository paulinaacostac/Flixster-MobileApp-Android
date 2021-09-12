package com.codepath.paulina.flixster.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.codepath.paulina.flixster.DetailActivity;
import com.codepath.paulina.flixster.MainActivity;
import com.codepath.paulina.flixster.R;
import com.codepath.paulina.flixster.models.Movie;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import org.parceler.Parcels;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>
{
    public static double POPULAR_RATING = 7.0;
    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies)
    {
        this.context = context;
        this.movies = movies;
    }

    // Usually involves inflating a layout from XML and returning holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter","onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(movieView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter","onBindViewHolder "+position);
        // Get the move at the passed in position
        Movie movie = movies.get(position);
        // Bind the movie data into the VH
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout container;
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;
        ImageView ivYoutubeIcon;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivYoutubeIcon = itemView.findViewById(R.id.ivYoutubeLogo);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Movie movie)
        {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            String imageUrl;
            // if phone is in landscape
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            {
                // then imageUrl = backdrop image
                imageUrl = movie.getBackdropPath();
            }
            else
            {
                // else imageUrl = poster image
                imageUrl = movie.getPosterPath();
            }

            // For unit 2 adding rounded corners
            int radius = 50; // corner radius, higher value = more rounded
            int margin = 100; // crop margin, set to 0 for corners with no crop
            GlideApp.with(context)
                    .load(imageUrl)
                    .centerCrop()
                    .transform(new RoundedCornersTransformation(radius,margin))
                    .into(ivPoster);

            //Unit 2

            if(movie.getRating() <= POPULAR_RATING)
            {
                ivYoutubeIcon.setVisibility(View.INVISIBLE);
            }
            // 1. Register click listener on the whole row
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 2. Navigate to a new activity on tap
                    Intent i = new Intent(context, DetailActivity.class);
                    //i.putExtra("title",movie.getTitle()); ---> This is not needed anymore because instead of passing attribute by attribute to DetailActivity, we can use the Parcles third party library
                    i.putExtra("movie", Parcels.wrap(movie));

                    //**** Transition
                    // Pass data object in the bundle and populate details activity.
                    Pair<View, String> transitionTitle = Pair.create((View)tvTitle, "titleTransition");
                    Pair<View, String> transitionOverview = Pair.create((View)tvOverview, "overviewTransition");
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, transitionTitle, transitionOverview);
                    context.startActivity(i, options.toBundle());
                    //*****


                    //context.startActivity(i); Without transition

                }
            });
        }
    }

}
