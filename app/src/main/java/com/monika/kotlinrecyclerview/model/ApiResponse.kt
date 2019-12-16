package com.monika.kotlinrecyclerview.model

import java.util.ArrayList

class ApiResponse<T> {

    @SerializedName("title")
    var title: String? = null
    @SerializedName("rows")
    internal var objList:ArrayList<T>? = null

    fun getObjList(): ArrayList<T> {
        return objList!!
    }
}