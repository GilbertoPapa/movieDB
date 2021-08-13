package com.idm.moviedb.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.idm.moviedb.data.source.local.entity.MovieEntity
import com.idm.moviedb.vo.Resource

interface MovieDataSource {
    fun getMovieList(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getDetailMovie(movie_id: Int): LiveData<Resource<MovieEntity>>
    fun updateMovie(movie: MovieEntity)
    fun getAllFavoriteMovie(): LiveData<PagedList<MovieEntity>>
}