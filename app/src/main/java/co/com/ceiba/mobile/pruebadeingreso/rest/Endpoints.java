package co.com.ceiba.mobile.pruebadeingreso.rest;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.post.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.user.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Endpoints {
    public static final String URL_BASE = "https://jsonplaceholder.typicode.com";
    public static final String GET_USERS = "/users";
    public static final String GET_POST_USER = "/posts?";

    public interface listEndpoints{
        @GET(GET_USERS)
        Call<List<User>> getUser();

        @GET(GET_POST_USER)
        Call<List<Post>> getPosts(
                @Query("userId") String userId);
    }
}
