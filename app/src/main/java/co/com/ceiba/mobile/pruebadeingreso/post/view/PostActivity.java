package co.com.ceiba.mobile.pruebadeingreso.post.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PostContract;
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PostPresenter;

public class PostActivity extends Activity implements PostContract.View {

    ViewSwitcher mListViewSwitcher;
    RecyclerView mListRecyclerView;

    private PostContract.Presenter mPresenter;
    private PostRecyclerViewAdapter mAdapter;
    private ArrayList<Post> mPostList = new ArrayList<>();

    public static String USER_ID_CUSTOM = "user_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initializeComponents();
    }

    @Override
    public void isLoading(boolean isLoading) {

    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(PostContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void displayPost(List<Post> postList) {
        if (postList != null) {
            validationEmptyList(false);
            mPostList.clear();
            mPostList.addAll(mPostList);
            mAdapter.notifyDataSetChanged();
        } else {
            validationEmptyList(true);
            mPostList.clear();
            mAdapter.notifyDataSetChanged();
        }
    }

    private void initializeComponents() {
        mAdapter = new PostRecyclerViewAdapter(this, mPostList);

        mListViewSwitcher = findViewById(R.id.viewSwitcherList);

        mListRecyclerView = findViewById(R.id.recyclerViewPostsResults);
        mListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListRecyclerView.setAdapter(mAdapter);

        setPresenter(new PostPresenter(this, this));

        mPresenter.getPosts(getIntent().getExtras().getString(USER_ID_CUSTOM));
    }

    private void validationEmptyList(boolean isEmpty) {
        if (!isEmpty) {
            mListViewSwitcher.setDisplayedChild(0);
            mListRecyclerView.setVisibility(View.VISIBLE);
        } else {
            mListRecyclerView.setVisibility(View.GONE);
            mListViewSwitcher.setDisplayedChild(1);
        }
    }
}
