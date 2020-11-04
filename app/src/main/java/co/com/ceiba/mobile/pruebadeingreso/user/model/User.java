package co.com.ceiba.mobile.pruebadeingreso.user.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 *
 * </p>
 *
 * Create By Zorayda 11/3/2020
 * @author Mona15 2020
 * @version 1.0
 */
public class User {
    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("username")
    @Expose
    String username;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("address")
    @Expose
    Address address;
    @SerializedName("phone")
    @Expose
    String phone;
    @SerializedName("website")
    @Expose
    String website;
    @SerializedName("company")
    @Expose
    Company company;
}
