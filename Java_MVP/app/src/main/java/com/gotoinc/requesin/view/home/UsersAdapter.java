package com.gotoinc.requesin.view.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gotoinc.requesin.R;
import com.gotoinc.requesin.view._model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Illia Derevianko on 26.11.18.
 * GoTo Inc.
 */
public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserHolder> {
    private Context context;
    private List<User> users;

    private HomeFragment.OnItemClick callback;

    public UsersAdapter(Context context, List<User> users, HomeFragment.OnItemClick callback) {
        this.context = context;
        this.users = users;
        this.callback = callback;
    }

    public List<User> getData() {
        return users;
    }

    public void setData(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UsersAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UserHolder holder, int position) {
        Picasso.get().load(users.get(position).getAvatar()).fit().centerCrop().into(holder.image);
        holder.txtFullname.setText(users.get(position).getFullname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        private CardView root;
        private AppCompatImageView image;
        private AppCompatTextView txtFullname;

        UserHolder(View v) {
            super(v);
            root = v.findViewById(R.id.root);
            image = v.findViewById(R.id.image);
            txtFullname = v.findViewById(R.id.txt_fullname);

            root.setOnClickListener(view -> callback.onItemClick(users.get(getAdapterPosition())));
        }
    }
}
