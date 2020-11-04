package co.com.ceiba.mobile.pruebadeingreso.rest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import co.com.ceiba.mobile.pruebadeingreso.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackCustom<T> implements Callback<T> {
    private Context mContext;

    public CallbackCustom(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (!response.isSuccessful()) {
            try {
                String messageError = "";
                if (response.errorBody() != null){
                    messageError = response.errorBody().string();
                }
                JSONObject errorBody = new JSONObject(messageError);

                String message = errorBody.has("mensaje") ? errorBody.getString("mensaje") :
                        errorBody.has("message") ? errorBody.getString("message") :
                                mContext.getString(R.string.error);

                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(mContext, mContext.getString(R.string.error), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        t.printStackTrace();
    }
}
