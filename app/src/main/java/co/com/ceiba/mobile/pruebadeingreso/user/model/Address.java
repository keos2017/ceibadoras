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
public class Address {
    @SerializedName("street")
    @Expose
    String street;
    @SerializedName("suite")
    @Expose
    String suite;
    @SerializedName("city")
    @Expose
    String city;
    @SerializedName("zipcode")
    @Expose
    String zipcode;
    @SerializedName("geo")
    @Expose
    Geo geo;
}
