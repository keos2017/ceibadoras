package co.com.ceiba.mobile.pruebadeingreso.post.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ViewSwitcher;

import co.com.ceiba.mobile.pruebadeingreso.R;

public class PostActivity extends Activity {

    ViewSwitcher mListViewSwitcher;
    RecyclerView mListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initializeComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initializeComponents() {
        mListViewSwitcher = findViewById(R.id.viewSwitcherList);
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
