package com.quangtkd.kotlintest.model
import com.google.gson.annotations.SerializedName



data class UV(
    @SerializedName("lat") var lat: Double,
    @SerializedName("lon") var lon: Double,
    @SerializedName("date_iso") var dateIso: String,
    @SerializedName("date") var date: Int,
    @SerializedName("value") var value: Double
)