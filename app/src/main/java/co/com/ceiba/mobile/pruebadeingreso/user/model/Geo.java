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
public class Geo {
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;
}
