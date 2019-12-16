package com.monika.kotlinrecyclerview.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Facts(@SerializedName(value = "title") var title: String,
                 @SerializedName(value = "description") var description: String,
                 @SerializedName(value = "imageHref") var imageHref: String) {
    constructor() : this("", "", "")

}