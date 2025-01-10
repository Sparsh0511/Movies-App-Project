package com.ahmedapps.moviesapp.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ahmedapps.moviesapp.core.presentation.components.MovieItem
import com.ahmedapps.moviesapp.movieList.presentaion.MovieListState
import com.ahmedapps.moviesapp.movieList.presentaion.MovieListUiEvent
import com.ahmedapps.moviesapp.movieList.util.Category

@Composable
fun PopularMoviesScreen(
    movieStateList: MovieListState,
    navHostController: NavHostController,
    onEvent: (MovieListUiEvent) -> Unit
) {
    if(movieStateList.popularMovieList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
    }
    else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
        ) {
            items(movieStateList.popularMovieList.size) { index ->
                MovieItem(
                    movie = movieStateList.popularMovieList[index],
                    navHostController = navHostController
                )

                Spacer(Modifier.height(16.dp))

                if(index >= movieStateList.popularMovieList.size-1 && !movieStateList.isLoading ) {
                    onEvent(MovieListUiEvent.Paginate(Category.POPULAR))
                }
            }
        }
    }
}