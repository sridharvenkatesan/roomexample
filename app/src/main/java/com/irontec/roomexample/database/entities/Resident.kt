package com.irontec.roomexample.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Resident constructor(birthDate: String, communityId: Int, companyId: Int, dateCreated: String, dateModified: String, email: String,
                           isActive: Int, isMarketing: Int, isNewProfilePage: Int, isShared: Int, photoCreateDate: String, profilePictureUrl: String,
                           residentId: String, residentName: String, roles: String, storyIdentifier: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "birth_date")
    var birthDate: String? = birthDate

    @ColumnInfo(name = "community_id")
    var communityId: Int? = communityId

    @ColumnInfo(name = "company_id")
    var companyId: Int? = companyId

    @ColumnInfo(name = "date_created")
    var dateCreated: String? = dateCreated

    @ColumnInfo(name = "date_modified")
    var dateModified: String? = dateModified

    @ColumnInfo(name = "email")
    var email: String? = email

    @ColumnInfo(name = "is_active")
    var isActive: Int? = isActive

    @ColumnInfo(name = "is_marketing")
    var isMarketing: Int? = isMarketing

    @ColumnInfo(name = "is_new_profile_page")
    var isNewProfilePage: Int? = isNewProfilePage

    @ColumnInfo(name = "is_shared")
    var isShared: Int? = isShared

    @ColumnInfo(name = "photo_create_date")
    var photoCreateDate: String? = photoCreateDate

    @ColumnInfo(name = "profile_picture_url")
    var profilePictureUrl: String? = profilePictureUrl

    @ColumnInfo(name = "resident_id")
    var residentId: String? = residentId

    @ColumnInfo(name = "resident_name")
    var residentName: String? = residentName

    @ColumnInfo(name = "roles")
    var roles: String? = roles

    @ColumnInfo(name = "story_identifier")
    var storyIdentifier: String? = storyIdentifier
}