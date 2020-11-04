package co.com.ceiba.mobile.pruebadeingreso.base;

import co.com.ceiba.mobile.pruebadeingreso.user.model.User;

public class CustomInterfaces {
    public interface UserCallback {
        void onSuccess(User user);
        void onFailure(String message);
    }
}
