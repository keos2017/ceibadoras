package co.com.ceiba.mobile.pruebadeingreso.users.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Geo {
    @SerializedName("lat")
    @Expose
    private val lat: String? = null

    @SerializedName("lng")
    @Expose
    private val lng: String? = null
}
