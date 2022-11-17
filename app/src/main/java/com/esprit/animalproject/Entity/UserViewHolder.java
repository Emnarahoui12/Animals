package com.esprit.animalproject.Entity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.animalproject.R;

public class UserViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView name;
        TextView contact;

public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        photo= itemView.findViewById(R.id.imageView_vet);
        name = itemView.findViewById(R.id.textView_Name);
        contact = itemView.findViewById(R.id.textView_contact);
        }
}
