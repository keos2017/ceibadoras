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
public class Company {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("catchPhrase")
    @Expose
    String catchPhrase;
    @SerializedName("bs")
    @Expose
    String bs;
}
