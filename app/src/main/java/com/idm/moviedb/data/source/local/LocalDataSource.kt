package com.idm.moviedb.data.source.local

import androidx.paging.DataSource
import com.idm.moviedb.data.source.local.dao.MovieDao
import com.idm.moviedb.data.source.local.entity.MovieEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao
) {


    fun getMovieList(): DataSource.Factory<Int, MovieEntity> = movieDao.getMovieList()

    suspend fun insertMovieList(listMovie: ArrayList<MovieEntity>) =
        movieDao.insertListMovie(listMovie)

    fun updateMovie(movie: MovieEntity) {
        movie.favorite = !movie.favorite
        movieDao.updateMovie(movie)
    }

    fun getAllFavoriteMovieItems(): DataSource.Factory<Int, MovieEntity> =
        movieDao.getFavoritesAllMovieItems()

    fun getDetailMovie(movieId: Int) = movieDao.getDetailMovie(movieId)

}
