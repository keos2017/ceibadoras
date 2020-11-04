package co.com.ceiba.mobile.pruebadeingreso.user.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.user.model.User;
import co.com.ceiba.mobile.pruebadeingreso.user.presenter.UserContract;
import co.com.ceiba.mobile.pruebadeingreso.user.presenter.UserPresenter;

public class MainActivity extends Activity implements UserContract.View {

    private UserContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void setPresenter(UserContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void isLoading(boolean isLoading) {

    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayUsers(List<User> userList) {

    }

    private void initializeComponents() {
        setPresenter(new UserPresenter(this, this));
        mPresenter.getUsers();
    }
}