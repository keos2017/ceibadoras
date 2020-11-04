package co.com.ceiba.mobile.pruebadeingreso.user.presenter;

import android.content.Context;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.base.CustomInterfaces;
import co.com.ceiba.mobile.pruebadeingreso.user.model.User;
import co.com.ceiba.mobile.pruebadeingreso.user.model.UserRepository;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class UserPresenter implements UserContract.Presenter {
    private UserContract.View mView;
    private UserRepository mRepository;

    public UserPresenter(Context context, UserContract.View view) {
        mView = checkNotNull(view);
        mRepository = new UserRepository(context);
    }

    @Override
    public void getUsers() {
        mView.isLoading(true);
        mRepository.getUser(new CustomInterfaces.UserCallback() {
            @Override
            public void onSuccess(List<User> users) {
                mView.displayUsers(users);
                mView.isLoading(false);
            }

            @Override
            public void onFailure(String message) {
                mView.displayMessage(message);
                mView.isLoading(false);
            }
        });
    }
}
