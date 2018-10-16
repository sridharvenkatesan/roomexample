package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Moment

interface MomentDao {

    @get:Query("SELECT * FROM moment")
    val all: List<Moment>

    @Query("SELECT * FROM moment WHERE moment_identifier LIKE :moment AND " + "movie_identifier LIKE :movie LIMIT 1")
    fun findByName(moment: String, movie: String): Moment

    @Insert
    fun insert(moment: Moment)

    @Insert
    fun insertAll(moments: List<Moment>)

    @Delete
    fun delete(moment: Moment)

    @Query("DELETE FROM moment")
    fun deleteAll(moments: List<Moment>)
}