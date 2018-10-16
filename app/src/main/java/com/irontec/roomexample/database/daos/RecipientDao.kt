package com.irontec.roomexample.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.irontec.roomexample.database.entities.Recipient

@Dao
interface RecipientDao {
    @get:Query("SELECT * FROM recipient")
    val all: List<Recipient>

    @Insert
    fun insert(recipient: Recipient)

    @Insert
    fun insertAll(recipients: List<Recipient>)

    @Delete
    fun delete(recipient: Recipient)

    @Query("DELETE FROM recipient")
    fun deleteAll()
}