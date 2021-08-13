package com.idm.moviedb.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.idm.moviedb.data.source.local.dao.MovieDao
import com.idm.moviedb.data.source.local.entity.MovieEntity


@Database(
    entities = [
        MovieEntity::class],
    version = 1
)
abstract class MovieTvItemDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
