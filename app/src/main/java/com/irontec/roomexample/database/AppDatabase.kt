package com.irontec.roomexample.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.irontec.roomexample.database.daos.*

import com.irontec.roomexample.database.entities.*

/**
 * Created by axier on 7/2/18.
 */

@Database(entities = [(Story::class), (Moment::class), (Theme::class), (Resident::class), (Recipient::class), (Audio::class)], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun storyDao(): StoryDao

    abstract fun momentDao(): MomentDao

    abstract fun themeDao(): ThemeDao

    abstract fun residentDao(): ResidentDao

    abstract fun recipientDao(): RecipientDao

    abstract fun audioDao(): AudioDao

    companion object {

        /**
         * The only instance
         */
        private var sInstance: AppDatabase? = null

        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "onedaydb")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return sInstance!!
        }
    }

}
