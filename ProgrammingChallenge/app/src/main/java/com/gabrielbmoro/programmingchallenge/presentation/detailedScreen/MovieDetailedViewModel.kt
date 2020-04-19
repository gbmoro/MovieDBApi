package com.gabrielbmoro.programmingchallenge.presentation.detailedScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.gabrielbmoro.programmingchallenge.domain.model.Movie
import com.gabrielbmoro.programmingchallenge.domain.usecase.FavoriteMovieUseCase

class MovieDetailedViewModel(
        application: Application,
        private val favoriteMovieUseCase: FavoriteMovieUseCase
) : AndroidViewModel(application) {

    val favoriteLiveData = MutableLiveData<Boolean>()

    private var movie: Movie? = null

    fun setup(movie: Movie) {
        this.movie = movie
    }

    fun favoriteEvent(isToFavorite: Boolean): LiveData<Boolean>? {
        return movie?.let { movie ->
            liveData {
                emit(
                        if (isToFavorite)
                            favoriteMovieUseCase.favoriteMovie(movie)
                        else
                            favoriteMovieUseCase.unFavoriteMovie(movie)
                )
            }
        }

    }

    fun getMovie() = movie
}