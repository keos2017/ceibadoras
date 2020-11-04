package co.com.ceiba.mobile.pruebadeingreso.users.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Company {
    @SerializedName("name")
    @Expose
    private val name: String? = null

    @SerializedName("catchPhrase")
    @Expose
    private val catchPhrase: String? = null

    @SerializedName("bs")
    @Expose
    private val bs: String? = null
}
