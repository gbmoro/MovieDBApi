package com.gabrielbmoro.programmingchallenge.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.gabrielbmoro.programmingchallenge.models.FavoriteMovie

/**
 * This class provides the interfaces to access the data base tables.
 *
 * @author Gabriel Moro
 * @since 02/09/2018
 */
@Database(entities = [FavoriteMovie::class], version = 1, exportSchema = false)
abstract class DataBaseFactory : RoomDatabase() {

    /**
     * Provides moviedao
     */
    abstract fun favoriteMovieDao() : FavoriteMovieDAO

}