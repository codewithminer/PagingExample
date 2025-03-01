package com.example.pagingexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.pagingexample.databinding.SingleMovieItemBinding;
import com.example.pagingexample.model.Movie;

import kotlin.coroutines.CoroutineContext;

public class MoviesAdapter extends PagingDataAdapter<Movie, MoviesAdapter.MovieViewHolder> {

    public static final int LOADING_ITEM = 0;
    public static final int MOVIE_ITEM = 1;
    RequestManager glide;

    public MoviesAdapter(@NonNull DiffUtil.ItemCallback<Movie> diffCallback, RequestManager glide) {
        super(diffCallback);
        this.glide = glide;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(
                SingleMovieItemBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                )
        );
    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() ? MOVIE_ITEM : LOADING_ITEM;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie = getItem(position);

        if(currentMovie !=null){
            glide
                    .load("https://image.tmdb.org/t/p/w500"+currentMovie.getPosterPath())
                    .into(holder.binding.ivMovie);
            holder.binding.tvRating.setText(String.valueOf(currentMovie.getVoteAverage()));

        }


    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        SingleMovieItemBinding binding;

        public MovieViewHolder(@NonNull SingleMovieItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
