package co.com.ceiba.mobile.pruebadeingreso.users.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsersResponse {
    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("username")
    @Expose
    private var username: String? = null

    @SerializedName("email")
    @Expose
    private var email: String? = null

    @SerializedName("address")
    @Expose
    private var address: Address? = null

    @SerializedName("phone")
    @Expose
    private var phone: String? = null

    @SerializedName("website")
    @Expose
    private var website: String? = null

    @SerializedName("company")
    @Expose
    private var company: Company? = null
}