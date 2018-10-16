package com.irontec.roomexample.database.daos

import android.arch.persistence.room.*

import com.irontec.roomexample.database.entities.Audio
import com.irontec.roomexample.database.entities.Bill

/**
 * Created by axier on 7/2/18.
 */

@Dao
interface AudioDao {

    @get:Query("SELECT * FROM audio")
    val all: List<Audio>

    @Query("SELECT * FROM audio WHERE uid IN (:audioId)")
    fun loadAllByIds(audioId: Array<Int>): List<Audio>

    @Query("SELECT * FROM audio WHERE promo_code LIKE :promo AND " + "audio_url LIKE :url LIMIT 1")
    fun findByPromo(promo: String, url: String): Audio

    @Insert
    fun insert(audio: Audio)

    @Insert
    fun insertAll(audios: List<Audio>)

    @Update
    fun updateAudio(audio: Audio)

    @Query("DELETE FROM audio WHERE uid LIKE :position")
    fun deleteById(position: Int)

    @Delete
    fun delete(audio: Audio)

    @Query("DELETE FROM audio")
    fun deleteAll()

}
