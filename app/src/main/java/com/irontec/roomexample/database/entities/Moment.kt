package com.irontec.roomexample.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Moment constructor(dateCaptured: String, dateLastRendered: String, dateMovieUploaded: String, dateThumbnailUploaded: String,
                         isShared: String, momentIdentifier: String, momentLess: String, movieIdentifier: String, nameplateText: String, order: String,
                         provisionalMovie: String, remoteUrlString: String, secondaryNamePlate: String, shareUrlString: String, summary: String,
                         momentTitle: String, uploadIdentifier: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "date_captured")
    var dateCaptured: String? = dateCaptured

    @ColumnInfo(name = "date_last_rendered")
    var dateLastRendered: String? = dateLastRendered

    @ColumnInfo(name = "date_movie_uploaded")
    var dateMovieUploaded: String? = dateMovieUploaded

    @ColumnInfo(name = "date_thumbnail_uploaded")
    var dateThumbnailUploaded: String? = dateThumbnailUploaded

    @ColumnInfo(name = "is_shared")
    var isShared: String? = isShared

    @ColumnInfo(name = "moment_identifier")
    var momentIdentifier: String? = momentIdentifier

    @ColumnInfo(name = "moment_less")
    var momentLess: String? = momentLess

    @ColumnInfo(name = "movie_identifier")
    var movieIdentifier: String? = movieIdentifier

    @ColumnInfo(name = "nameplate_text")
    var nameplateText: String? = nameplateText

    @ColumnInfo(name = "order")
    var order: String? = order

    @ColumnInfo(name = "provisional_movie")
    var provisionalMovie: String? = provisionalMovie

    @ColumnInfo(name = "remote_url_string")
    var remoteUrlString: String? = remoteUrlString

    @ColumnInfo(name = "secondary_nameplate")
    var secondaryNamePlate: String? = secondaryNamePlate

    @ColumnInfo(name = "share_url_string")
    var shareUrlString: String? = shareUrlString

    @ColumnInfo(name = "summary")
    var summary: String? = summary

    @ColumnInfo(name = "moment_title")
    var momentTitle: String? = momentTitle

    @ColumnInfo(name = "upload_identifier")
    var uploadIdentifier: String? = uploadIdentifier
}
