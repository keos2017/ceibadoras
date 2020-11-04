package co.com.ceiba.mobile.pruebadeingreso.post.presenter;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.post.model.Post;

public interface PostContract {
    interface View {
        void isLoading(boolean isLoading);
        void displayMessage(String message);
        void setPresenter(Presenter presenter);
        void displayPost(List<Post> postList);
    }

    interface Presenter {
        void getPosts(String userId);
    }
}
