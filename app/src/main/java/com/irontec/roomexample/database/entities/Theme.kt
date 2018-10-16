package com.irontec.roomexample.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Theme constructor(datePurchased: String, identifier: String, inappPurchaseIdentifier: String, index: String, promoCode: String,
                        themeTemplate: String, title: String, updatedAt: String) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "date_purchased")
    var datePurchased: String? = datePurchased

    @ColumnInfo(name = "identifier")
    var identifier: String? = identifier

    @ColumnInfo(name = "inapp_purchase_identifier")
    var inappPurchaseIdentifier: String? = inappPurchaseIdentifier

    @ColumnInfo(name = "index")
    var index: String? = index

    @ColumnInfo(name = "promo_code")
    var promoCode: String? = promoCode

    @ColumnInfo(name = "theme_template")
    var themeTemplate: String? = themeTemplate

    @ColumnInfo(name = "title")
    var title: String? = title

    @ColumnInfo(name = "updated_at")
    var updatedAt: String? = updatedAt
}