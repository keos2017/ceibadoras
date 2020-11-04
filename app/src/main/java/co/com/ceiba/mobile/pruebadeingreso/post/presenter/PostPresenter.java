package co.com.ceiba.mobile.pruebadeingreso.post.presenter;

import android.content.Context;


import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.base.CustomInterfaces;
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.post.model.PostRepository;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class PostPresenter implements PostContract.Presenter {

    private PostContract.View mView;
    private PostRepository mRepository;

    public PostPresenter(Context context, PostContract.View view) {
        mView = checkNotNull(view);
        mRepository = new PostRepository(context);
    }

    @Override
    public void getPosts(String userId) {
        mView.isLoading(true);
        mRepository.getPosts(userId, new CustomInterfaces.PostCallback() {
            @Override
            public void onSuccess(List<Post> users) {
                mView.displayPost(users);
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
