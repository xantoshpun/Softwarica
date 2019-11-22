package com.example.softwarica.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwarica.R;
import com.example.softwarica.model.User;

import java.util.List;

public class User_Adapter extends RecyclerView.Adapter<User_Adapter.ViewHolder> {
    Context context;
    List<User> user_list;

    public User_Adapter(Context context, List<User> user_list) {
        this.context = context;
        this.user_list = user_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final User user = user_list.get(position);
        holder.name.setText(user.getName());

        holder.age.setText(user.getAge());
        holder.address.setText(user.getAddress());
        holder.gender.setText(user.getGender());
        holder.image.setImageResource(user.getImage());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_list.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return user_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, age, address, gender;
        ImageView image, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
            gender = itemView.findViewById(R.id.gender);
            image = itemView.findViewById(R.id.image);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
