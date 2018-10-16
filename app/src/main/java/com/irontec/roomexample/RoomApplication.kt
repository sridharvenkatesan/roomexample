package com.irontec.roomexample

import android.app.Application
import com.irontec.roomexample.database.AppDatabase
import com.irontec.roomexample.database.entities.*
import org.jetbrains.anko.doAsync

/**
 * Created by axier on 7/2/18.
 */

class RoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        var url: String = "https://tamil-tunes.com/mp3"
        doAsync {
            val database = AppDatabase.getInstance(context = this@RoomApplication)

            if (database.audioDao().all.isEmpty()) {
                val audios: MutableList<Audio> = mutableListOf()
                val file_name = "sample.json"
                val json_string = assets.open(file_name).bufferedReader().use {
                    it.readText()
                }
                for (index: Int in 0..5) {
                    val client = Audio(json_string.toByteArray(), url + index, "22-09-2018", "2",
                            "yes", "2895" + index, "oneday", "27-09-2018")
                    audios.add(index, client)
                }
                database.audioDao().insertAll(audios = audios)
            }

            if (database.themeDao().all.isEmpty()) {
                val themes: MutableList<Theme> = mutableListOf()
                for (index: Int in 0..5) {
                    val client = Theme(datePurchased = "12-10-18", identifier = "2", inappPurchaseIdentifier = "1", index = "" + index,
                            promoCode = "200" + index, themeTemplate = "", title = "theme" + index, updatedAt = "13=10-18")
                    themes.add(index, client)
                }
                database.themeDao().insertAll(themes = themes)
            }

            if (database.momentDao().all.isEmpty()) {
                val moments: MutableList<Moment> = mutableListOf()
                for (index: Int in 0..15) {
                    val client = Moment(dateCaptured = "08-10-18", dateLastRendered = "09-10-18", dateMovieUploaded = "10-10-18", dateThumbnailUploaded = "11-10-18", isShared = "yes",
                            momentIdentifier = "1", momentLess = "no", movieIdentifier = "2", nameplateText = "", order = "", provisionalMovie = "", remoteUrlString = "", secondaryNamePlate = "",
                            shareUrlString = "", summary = "", momentTitle = "moment" + index, uploadIdentifier = "3")
                    moments.add(index, client)
                }
                database.momentDao().insertAll(moments = moments)
            }

            if (database.residentDao().all.isEmpty()) {
                val residents: MutableList<Resident> = mutableListOf()
                for (index: Int in 0..15) {
                    val client = Resident(birthDate = "12-10-67", communityId = 201 + index, companyId = 101 + index, dateCreated = "10-10-18", dateModified = "11-10-18", email = "oneday" + index + "@gmail.com",
                            isActive = 1, isMarketing = 0, isNewProfilePage = 1, isShared = 2, photoCreateDate = "08-10-18", profilePictureUrl = "", residentId = "111" + index, residentName = "resident" + index,
                            roles = "role" + index, storyIdentifier = "2")
                    residents.add(index, client)
                }
                database.residentDao().insertAll(residents = residents)
            }

            if (database.recipientDao().all.isEmpty()) {
                val recipients: MutableList<Recipient> = mutableListOf()
                for (index: Int in 0..15) {
                    val client = Recipient(dateCreated = "10-10-18", dateModified = "11-10-18", emailAddress = "recipient" + index + "@gmail.com", isActive = 1, isShared = 2, phoneNumber = "900311422" + index,
                            profilePictureUrl = "", recipientName = "recipient" + index, recipientId = "", residentId = "", roles = "", storyId = "")
                    recipients.add(index, client)
                }
                database.recipientDao().insertAll(recipients = recipients)
            }

        }
    }

}
