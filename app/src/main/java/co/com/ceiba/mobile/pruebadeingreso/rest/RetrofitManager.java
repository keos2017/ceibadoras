package co.com.ceiba.mobile.pruebadeingreso.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>
 *    Permite el manejo personalizado de Retrofit con
 *    configuraciones generales para las conexiones
 * </p>
 *
 * Create By Zorayda 11/3/2020
 * @author Mona15 2020
 * @version 1.0
 */
public class RetrofitManager {

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    private Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public Endpoints.listEndpoints create(String url){

        Retrofit.Builder builder = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit mRetrofit = builder.build();
        return mRetrofit.create(Endpoints.listEndpoints.class);
    }
}
