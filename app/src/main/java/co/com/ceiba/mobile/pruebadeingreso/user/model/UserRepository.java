package co.com.ceiba.mobile.pruebadeingreso.user.model;

import android.content.Context;
import android.support.annotation.NonNull;
import co.com.ceiba.mobile.pruebadeingreso.base.CustomInterfaces;
import co.com.ceiba.mobile.pruebadeingreso.rest.CallbackCustom;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;
import co.com.ceiba.mobile.pruebadeingreso.rest.RetrofitManager;
import retrofit2.Call;
import retrofit2.Response;

import static co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.URL_BASE;

/**
 * <p>
 *
 * </p>
 *
 * Create By Zorayda 11/3/2020
 * @author Mona15 2020
 * @version 1.0
 */
public class UserRepository {
    private Context mContext;
    private Endpoints.listEndpoints mEndpoints;

    public UserRepository(Context context) {
        mContext = context;
        mEndpoints = new RetrofitManager().create(URL_BASE);
    }

    public void getUser(final CustomInterfaces.UserCallback mCallback){
        mEndpoints.getUser().enqueue(new CallbackCustom<User>(mContext){
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    mCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                t.printStackTrace();
                mCallback.onFailure(t.getMessage());
            }
        });
    }
}
