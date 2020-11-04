package co.com.ceiba.mobile.pruebadeingreso.base;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.post.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.user.model.User;

public class CustomInterfaces {
    public interface UserCallback {
        void onSuccess(List<User> user);
        void onFailure(String message);
    }

    public interface PostCallback {
        void onSuccess(List<Post> posts);
        void onFailure(String message);
    }
}
