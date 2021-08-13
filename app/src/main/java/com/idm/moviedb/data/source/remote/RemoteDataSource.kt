package com.idm.moviedb.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.idm.moviedb.data.source.remote.response.movie.MovieResponse
import com.idm.moviedb.data.source.remote.response.movie.detail.MovieDetailResponse
import com.idm.moviedb.utils.Constant
import com.idm.moviedb.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val apiService: ApiService) {


    fun getNowPlaying(): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val listNowPlaying = MutableLiveData<ApiResponse<MovieResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getNowPlaying(Constant.API_KEY)
            if (response.isSuccessful) {
                listNowPlaying.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()
            } else {
                listNowPlaying.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })

            }
        }
        return listNowPlaying
    }

    fun getDetailMovie(movie_id: Int): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val detailMovie = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getDetailMovie(movie_id, Constant.API_KEY)
            if (response.isSuccessful) {
                detailMovie.postValue(response.body()?.let { ApiResponse.success(it) })
                EspressoIdlingResource.decrement()
                Log.d("getDetailMovie","isi ${response.body()}")
            } else {
                detailMovie.postValue(
                    response.body()?.let { ApiResponse.error(response.code().toString(), it) })
            }
        }
        return detailMovie
    }

}