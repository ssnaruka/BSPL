package com.example.bspl.models

import com.google.gson.JsonElement
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseApiModel(
    @SerializedName("code")
    @Expose
    var code: Int,
    @SerializedName("message")
    @Expose
    var message: String,
    @SerializedName("data")
    @Expose
    var data: JsonElement
)
