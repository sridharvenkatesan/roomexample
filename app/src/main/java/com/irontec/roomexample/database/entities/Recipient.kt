package com.irontec.roomexample.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Recipient constructor(dateCreated: String, dateModified: String, emailAddress: String, isActive: Int, isShared: Int, phoneNumber: String,
                            profilePictureUrl: String, recipientId: String, recipientName: String, residentId: String, roles: String, storyId: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "date_created")
    var dateCreated: String? = dateCreated

    @ColumnInfo(name = "date_modified")
    var dateModified: String? = dateModified

    @ColumnInfo(name = "email_address")
    var emailAddress: String? = emailAddress

    @ColumnInfo(name = "is_active")
    var isActive: Int? = isActive

    @ColumnInfo(name = "is_shared")
    var isShared: Int? = isShared

    @ColumnInfo(name = "phone_number")
    var phoneNumber: String? = phoneNumber

    @ColumnInfo(name = "profile_picture_url")
    var profilePictureUrl: String? = profilePictureUrl

    @ColumnInfo(name = "recipient_id")
    var recipientId: String? = recipientId

    @ColumnInfo(name = "recipient_name")
    var recipientName: String? = recipientName

    @ColumnInfo(name = "resident_id")
    var residentId: String? = residentId

    @ColumnInfo(name = "roles")
    var roles: String? = roles

    @ColumnInfo(name = "story_id")
    var storyId: String? = storyId
}