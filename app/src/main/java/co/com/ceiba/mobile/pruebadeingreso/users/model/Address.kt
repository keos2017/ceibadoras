package co.com.ceiba.mobile.pruebadeingreso.users.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Address {
    @SerializedName("street")
    @Expose
    private val street: String? = null

    @SerializedName("suite")
    @Expose
    private val suite: String? = null

    @SerializedName("city")
    @Expose
    private val city: String? = null

    @SerializedName("zipcode")
    @Expose
    private val zipcode: String? = null

    @SerializedName("geo")
    @Expose
    private val geo: Geo? = null
}
