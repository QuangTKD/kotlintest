package com.quangtkd.kotlintest.model
import com.google.gson.annotations.SerializedName



data class FiveDayWeather(
    @SerializedName("cod") var cod: String,
    @SerializedName("message") var message: Double,
    @SerializedName("cnt") var cnt: Int,
    @SerializedName("list") var list: List<WeatherX>,
    @SerializedName("city") var city: City5days
)

data class WeatherX(
    @SerializedName("dt") var dt: Int,
    @SerializedName("main") var main: Main5days,
    @SerializedName("weather") var weather: List<Weather5days>,
    @SerializedName("clouds") var clouds: Clouds,
    @SerializedName("wind") var wind: Wind5days,
    @SerializedName("rain") var rain: Rain,
    @SerializedName("sys") var sys: Sys5days,
    @SerializedName("dt_txt") var dtTxt: String
)

data class Main5days(
    @SerializedName("temp") var temp: Double,
    @SerializedName("temp_min") var tempMin: Double,
    @SerializedName("temp_max") var tempMax: Double,
    @SerializedName("pressure") var pressure: Double,
    @SerializedName("sea_level") var seaLevel: Double,
    @SerializedName("grnd_level") var grndLevel: Double,
    @SerializedName("humidity") var humidity: Int,
    @SerializedName("temp_kf") var tempKf: Double
)

data class Weather5days(
    @SerializedName("id") var id: Int,
    @SerializedName("main") var main: String,
    @SerializedName("description") var description: String,
    @SerializedName("icon") var icon: String
)

data class Rain(
        @SerializedName("3h") var threeHours: Double
)

data class Wind5days(
    @SerializedName("speed") var speed: Double,
    @SerializedName("deg") var deg: Double
)



data class Sys5days(
    @SerializedName("pod") var pod: String
)

data class City5days(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("coord") var coord: Coord,
    @SerializedName("country") var country: String
)

