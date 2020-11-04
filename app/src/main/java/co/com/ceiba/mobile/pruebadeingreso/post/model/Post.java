package co.com.ceiba.mobile.pruebadeingreso.post.model;

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
public class Post {
    @SerializedName("userId")
    @Expose
    Integer userId;
    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("body")
    @Expose
    String body;
}
