package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Theme

@Dao
interface ThemeDao {
    @get:Query("SELECT * FROM theme")
    val all: List<Theme>

    @Insert
    fun insert(theme: Theme)

    @Insert
    fun insertAll(themes: List<Theme>)

    @Delete
    fun delete(theme: Theme)

    @Query("DELETE FROM theme")
    fun deleteAll()

}