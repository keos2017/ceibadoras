package co.com.ceiba.mobile.pruebadeingreso.user.model;

import android.content.Context;

import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;
import co.com.ceiba.mobile.pruebadeingreso.rest.RetrofitManager;

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

    public void getUser(){
        //mEndpoints.getUser().enqueue();
    }
}
