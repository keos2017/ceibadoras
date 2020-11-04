package co.com.ceiba.mobile.pruebadeingreso.post.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.base.ConfigUtils;
import co.com.ceiba.mobile.pruebadeingreso.post.model.Post;

public class PostRecyclerViewAdapter  extends RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<Post> mList;
    private View.OnClickListener mListener;

    PostRecyclerViewAdapter(Context context, List<Post> postList) {
        mContext = context;
        mList = postList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.post_list_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = mList.get(position);
        holder.addPost(post);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onClick(view);
        }
    }

    void setOnClickListener(View.OnClickListener listener) {
        this.mListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleTextView, mBodyTextView;

        ViewHolder(View mView) {
            super(mView);
            mTitleTextView = mView.findViewById(R.id.title);
            mBodyTextView = mView.findViewById(R.id.body);
        }

        void addPost(Post post) {
            mTitleTextView.setText(ConfigUtils.putCapitalInitial(post.title));
            mBodyTextView.setText(ConfigUtils.putCapitalInitial(post.body));
        }
    }
}
