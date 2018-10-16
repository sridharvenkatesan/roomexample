package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*
import java.util.*



@Entity(foreignKeys =
[
    ForeignKey(
            entity = Audio::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("audio_id"),
            onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
            entity = Moment::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("moment_id"),
            onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
            entity = Resident::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("resident_id"),
            onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
            entity = Theme::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("theme_id"),
            onDelete = ForeignKey.CASCADE
    )
], indices = [Index(value = "audio_id"), Index(value = "moment_id"), Index(value = "resident_id"), Index(value = "theme_id")]
)
class Story constructor(audioDatePurchased: String, audioFileName: String, audioIdentifier: String, audioInappPurchased: String, audioName: String,
                        audioUrl: String, dateBegan: String, dateCreatedMovie: String, dateLastRendered: String, dateMovieUploaded: String, dateThumbnailUploaded: String,
                        defaultMusicFile: String, inviteStatus: Int, isActive: Int, isShared: Int, momentsOrder: String, movieIdentifier: String, order: String,
                        provisionalMovieIdentifier: String, remoteUrlString: String, restoredMovieId: String, audioIds: MutableList<Int>, momentIds: MutableList<Int>,
                        residentIds: MutableList<Int>, themeIds: MutableList<Int>) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "audio_date_purchased")
    var audioDatePurchased: String? = audioDatePurchased

    @ColumnInfo(name = "audio_file_name")
    var audioFileName: String? = audioFileName

    @ColumnInfo(name = "audio_identifier")
    var audioIdentifier: String? = audioIdentifier

    @ColumnInfo(name = "audio_inapp_purchased")
    var audioInappPurchased: String? = audioInappPurchased

    @ColumnInfo(name = "audio_name")
    var audioName: String? = audioName

    @ColumnInfo(name = "audio_url")
    var audioUrl: String? = audioUrl

    @ColumnInfo(name = "date_began")
    var dateBegan: String? = dateBegan

    @ColumnInfo(name = "date_created_movie")
    var dateCreatedMovie: String? = dateCreatedMovie

    @ColumnInfo(name = "date_last_rendered")
    var dateLastRendered: String? = dateLastRendered

    @ColumnInfo(name = "date_movie_uploaded")
    var dateMovieUploaded: String? = dateMovieUploaded

    @ColumnInfo(name = "date_thumbnail_uploaded")
    var dateThumbnailUploaded: String? = dateThumbnailUploaded

    @ColumnInfo(name = "default_music_file")
    var defaultMusicFile: String? = defaultMusicFile

    @ColumnInfo(name = "invite_status")
    var inviteStatus: Int? = inviteStatus

    @ColumnInfo(name = "is_active")
    var isActive: Int? = isActive

    @ColumnInfo(name = "is_shared")
    var isShared: Int? = isShared

    @ColumnInfo(name = "moments_order")
    var momentsOrder: String? = momentsOrder

    @ColumnInfo(name = "movie_identifier")
    var movieIdentifier: String? = movieIdentifier

    @ColumnInfo(name = "order")
    var order: String? = order

    @ColumnInfo(name = "provisional_movie_identifier")
    var provisionalMovieIdentifier: String? = provisionalMovieIdentifier

    @ColumnInfo(name = "remote_url_string")
    var remoteUrlString: String? = remoteUrlString

    @ColumnInfo(name = "restored_movie_id")
    var restoredMovieId: String? = restoredMovieId

    @ColumnInfo(name = "audio_id")
    var audioId: ByteArray = audioIds

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<SomeObject> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<SomeObject>>() {

        }.getType()

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<SomeObject>): String {
        return gson.toJson(someObjects)
    }
}