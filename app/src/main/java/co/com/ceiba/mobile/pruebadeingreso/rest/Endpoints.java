package co.com.ceiba.mobile.pruebadeingreso.rest;

import co.com.ceiba.mobile.pruebadeingreso.users.model.UsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * <p>
 *  Interfaz para realizar solicitudes, trabajando bajo
 *  el client Rest Retrofit. Aquí se colocan los parámetros
 *  que va a recibir cada webservice
 * </p>
 *
 * Create By Zorayda Gutierrez 10/30/2020
 * @author Equipo android 2020
 * @version 1.0
 */
public interface Endpoints {

    @GET("users/")
    Call<UsersResponse> endpointGetUsers();

    /*@GET("posts/")
    Call<PostsResponse> endpointGetPosts(
            @Query("userId") String userId);*/
}