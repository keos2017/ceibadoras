package co.com.ceiba.mobile.pruebadeingreso.user.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.user.model.User;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> implements View.OnClickListener{

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<User> mList;
    private View.OnClickListener mListener;
    private View.OnClickListener mOnClickListener;

    UserRecyclerViewAdapter(Context context, List<User> userList){
        mContext = context;
        mList = userList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.user_list_item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         User user = mList.get(position);
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

    static class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder (View mView) {
            super(mView);
            TextView mNameTextView = mView.findViewById(R.id.name);
            TextView mPhoneTextView = mView.findViewById(R.id.phone);
            TextView mEmailTextView = mView.findViewById(R.id.email);
        }
    }
}
