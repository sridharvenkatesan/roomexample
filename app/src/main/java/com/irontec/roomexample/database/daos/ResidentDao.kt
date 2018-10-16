package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Resident

@Dao
interface ResidentDao {
    @get:Query("SELECT * FROM resident")
    val all: List<Resident>

    @Insert
    fun insert(resident: Resident)

    @Insert
    fun insertAll(residents: List<Resident>)

    @Delete
    fun delete(resident: Resident)

    @Query("DELETE FROM resident")
    fun deleteAll()
}