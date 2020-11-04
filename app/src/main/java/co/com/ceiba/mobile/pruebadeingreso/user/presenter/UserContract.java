package co.com.ceiba.mobile.pruebadeingreso.user.presenter;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.user.model.User;

public interface UserContract {
    interface View {
        void isLoading(boolean isLoading);
        void displayMessage(String message);
        void setPresenter(Presenter presenter);
        void displayUsers(List<User> userList);
    }

    interface Presenter {
        void getUsers();
    }
}