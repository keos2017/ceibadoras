package co.com.ceiba.mobile.pruebadeingreso.post.model;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.base.CustomInterfaces;
import co.com.ceiba.mobile.pruebadeingreso.rest.CallbackCustom;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;
import co.com.ceiba.mobile.pruebadeingreso.rest.RetrofitManager;
import retrofit2.Call;
import retrofit2.Response;

import static co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.URL_BASE;

public class PostRepository {
    private Context mContext;
    private Endpoints.listEndpoints mEndpoints;

    public PostRepository(Context context) {
        mContext = context;
        mEndpoints = new RetrofitManager().create(URL_BASE);
    }

    public void getPosts(String userId, final CustomInterfaces.PostCallback mCallback){
        mEndpoints.getPosts(userId).enqueue(new CallbackCustom<List<Post>>(mContext){
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    mCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                t.printStackTrace();
                mCallback.onFailure(t.getMessage());
            }
        });
    }
}
