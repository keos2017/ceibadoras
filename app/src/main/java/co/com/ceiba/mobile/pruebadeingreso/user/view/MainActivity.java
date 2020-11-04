package co.com.ceiba.mobile.pruebadeingreso.user.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.post.view.PostActivity;
import co.com.ceiba.mobile.pruebadeingreso.user.model.User;
import co.com.ceiba.mobile.pruebadeingreso.user.presenter.UserContract;
import co.com.ceiba.mobile.pruebadeingreso.user.presenter.UserPresenter;

import static io.realm.permissions.UserCondition.MatcherType.USER_ID;

public class MainActivity extends Activity implements UserContract.View {

    private UserContract.Presenter mPresenter;
    private UserRecyclerViewAdapter mAdapter;
    private ArrayList<User> mUserList = new ArrayList<>();
    private RecyclerView mListRecyclerView;

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
        mUserList.clear();
        mUserList.addAll(userList);
        mAdapter.notifyDataSetChanged();
    }

    private void initializeComponents() {
        mAdapter = new UserRecyclerViewAdapter(this, mUserList);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                //intent.putExtra(USER_ID, "10");
                startActivity(intent);
            }
        });

        mListRecyclerView = findViewById(R.id.recyclerViewSearchResults);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListRecyclerView.setAdapter(mAdapter);

        setPresenter(new UserPresenter(this, this));
        mPresenter.getUsers();
    }
}