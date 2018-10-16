package com.irontec.roomexample.database.daos

import android.arch.persistence.room.*
import com.irontec.roomexample.database.entities.Audio
import com.irontec.roomexample.database.entities.Story

@Dao
interface StoryDao {

    @get:Query("SELECT * FROM story")
    val all: List<Story>

    @Query("SELECT * FROM story WHERE uid IN (:storyId)")
    fun loadAllByIds(storyId: Array<Int>): List<Story>

//    @Query("SELECT * FROM story WHERE promo_code LIKE :promo AND " + "audio_url LIKE :url LIMIT 1")
//    fun findByPromo(promo: String, url: String): Story

    @Insert
    fun insert(story: Story)

    @Insert
    fun insertAll(stories: List<Story>)

    @Update
    fun updateAudio(story: Story)

    @Query("DELETE FROM story WHERE uid LIKE :position")
    fun deleteById(position: Int)

    @Delete
    fun delete(story: Story)

    @Query("DELETE FROM story")
    fun deleteAll()

}