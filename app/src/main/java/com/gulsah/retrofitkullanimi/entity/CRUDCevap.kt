package com.gulsah.retrofitkullanimi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUDCevap(
    @SerializedName("success")
    @Expose
    var success: Int,
    @SerializedName("message")
    @Expose
    var message: String
) {
}