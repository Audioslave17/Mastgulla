package com.example.mastgulla.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastgulla.MenuActivity;
import com.example.mastgulla.R;
import com.example.mastgulla.models.AllRestaurantModels;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class AllRestaurantsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<AllRestaurantModels> list;

    public AllRestaurantsAdapter(Context context, List<AllRestaurantModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AllRestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllRestaurantViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_res_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof AllRestaurantViewHolder) {
            ((AllRestaurantViewHolder) holder).roundedImageView.setImageResource(list.get(position).getImage());
            ((AllRestaurantViewHolder) holder).name.setText(list.get(position).getName());
            ((AllRestaurantViewHolder) holder).timing.setText(list.get(position).getTiming());
            ((AllRestaurantViewHolder) holder).rating.setText(list.get(position).getRating());
        }


        ((AllRestaurantViewHolder) holder).roundedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MenuActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AllRestaurantViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView roundedImageView;
        TextView name,timing,rating;
        public AllRestaurantViewHolder(View itemView) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.roundedImageView2);
            name = itemView.findViewById(R.id.textView4);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.textView5);

        }
    }
}
