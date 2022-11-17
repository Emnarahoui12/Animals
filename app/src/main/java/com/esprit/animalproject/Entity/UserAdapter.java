package com.esprit.animalproject.Entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.animalproject.DataBase.UserDataBase;
import com.esprit.animalproject.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{

    List<Users> userList;

    UserAdapter(Context context) {
        UserDataBase db = UserDataBase.getDatabase(context);
        userList = db.getUserDao().getAllUsers();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Users us = userList.get(position);

        holder.name.setText(us.getUserName());
        holder.contact.setText(String.valueOf(us.getEmail()));

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), us.getUserName() + " Clicked", Toast.LENGTH_SHORT).show();

        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
