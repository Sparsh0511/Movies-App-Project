package com.ahmedapps.moviesapp.details.presentation

import com.ahmedapps.moviesapp.movieList.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)
