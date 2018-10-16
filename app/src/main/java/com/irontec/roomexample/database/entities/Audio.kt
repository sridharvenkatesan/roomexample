package com.irontec.roomexample.database.entities

import android.arch.persistence.room.*

/**
 * Created by axier on 7/2/18.
 */

@Entity
class Audio constructor(audioTemplate: ByteArray, audioUrl: String, datePurchased: String, identifier: String,
                        inAppPurchased: String, promoCode: String, audioTitle: String, updatedAt: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "audio_template")
    var audioTemplate: ByteArray? = audioTemplate

    @ColumnInfo(name = "audio_url")
    var audioUrl: String? = audioUrl

    @ColumnInfo(name = "date_purchased")
    var datePurchased: String? = datePurchased

    @ColumnInfo(name = "identifier")
    var identifier: String? = identifier

    @ColumnInfo(name = "in_app_purchased")
    var inAppPurchased: String? = inAppPurchased

    @ColumnInfo(name = "promo_code")
    var promoCode: String? = promoCode

    @ColumnInfo(name = "audio_title")
    var audioTitle: String? = audioTitle

    @ColumnInfo(name = "updated_at")
    var updatedAt: String? = updatedAt

}
