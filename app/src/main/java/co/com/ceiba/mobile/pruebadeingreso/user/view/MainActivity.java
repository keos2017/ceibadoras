package co.com.ceiba.mobile.pruebadeingreso.user.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.base.CustomInterfaces;
import co.com.ceiba.mobile.pruebadeingreso.post.view.PostActivity;
import co.com.ceiba.mobile.pruebadeingreso.user.model.User;
import co.com.ceiba.mobile.pruebadeingreso.user.presenter.UserContract;
import co.com.ceiba.mobile.pruebadeingreso.user.presenter.UserPresenter;

import static co.com.ceiba.mobile.pruebadeingreso.post.view.PostActivity.USER_ID_CUSTOM;

public class MainActivity extends Activity implements UserContract.View {

    private UserContract.Presenter mPresenter;
    private UserRecyclerViewAdapter mAdapter;
    private ArrayList<User> mUserList = new ArrayList<>();
    private RecyclerView mListRecyclerView;
    private ViewSwitcher mListViewSwitcher;

    SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        initializeSearch();
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

        if (userList != null){
            mUserList.clear();
            mUserList.addAll(userList);
            mAdapter.notifyDataSetChanged();
            validationEmptyList(true);
        } else {
            validationEmptyList(false);
        }
    }

    private void initializeComponents() {
        mAdapter = new UserRecyclerViewAdapter(this, mUserList);
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User mUser = mUserList.get(mListRecyclerView.getChildAdapterPosition(view));
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                intent.putExtra(USER_ID_CUSTOM, String.valueOf(mUser.id));
                startActivity(intent);
            }
        });

        mListViewSwitcher = findViewById(R.id.viewSwitcherList);
        mListRecyclerView = findViewById(R.id.recyclerViewSearchResults);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListRecyclerView.setAdapter(mAdapter);

        setPresenter(new UserPresenter(this, this));
        mPresenter.getUsers();

    }

    private void initializeSearch() {
        mSearchView = findViewById(R.id.searchView);
        mSearchView.setIconified(false);
        mSearchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.filter(newText, new CustomInterfaces.ShowUserCallback() {
                    @Override
                    public void show(ArrayList<User> list) {
                        validationListSearch(true, list);
                    }

                    @Override
                    public void empty() {
                        validationListSearch(false, null);
                    }
                });

                return false;
            }
        });
    }

    private void validationListSearch(boolean isEmpty, ArrayList<User> list) {
        if (isEmpty) {
            mListViewSwitcher.setDisplayedChild(0);
            mListRecyclerView.setVisibility(View.VISIBLE);

            mUserList.clear();
            mUserList.addAll(list);
            mAdapter.notifyDataSetChanged();
        } else {
            mListRecyclerView.setVisibility(View.GONE);
            mListViewSwitcher.setDisplayedChild(1);
        }
    }

    private void validationEmptyList(boolean isEmpty) {
        if (isEmpty) {
            mListViewSwitcher.setDisplayedChild(0);
            mListRecyclerView.setVisibility(View.VISIBLE);
        } else {
            mListRecyclerView.setVisibility(View.GONE);
            mListViewSwitcher.setDisplayedChild(1);
        }
    }
}