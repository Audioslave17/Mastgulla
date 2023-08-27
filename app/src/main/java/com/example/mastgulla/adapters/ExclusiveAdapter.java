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
import com.example.mastgulla.models.ExclusiveModels;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ExclusiveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    List<ExclusiveModels> list;

    public ExclusiveAdapter(Context context, List<ExclusiveModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ExclusiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExclusiveViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.exclusives_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ExclusiveAdapter.ExclusiveViewHolder) {
            ((ExclusiveViewHolder) holder).roundedImageView.setImageResource(list.get(position).getImage());
            ((ExclusiveViewHolder) holder).name.setText(list.get(position).getName());
            ((ExclusiveViewHolder) holder).rating.setText(list.get(position).getRating());
            ((ExclusiveViewHolder) holder).location.setText(list.get(position).getLocation());
        }

        ((ExclusiveViewHolder) holder).roundedImageView.setOnClickListener(new View.OnClickListener() {
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

    public class ExclusiveViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView roundedImageView;
        TextView name,location,rating;
        public ExclusiveViewHolder(View itemView) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.roundedImageView2);
            name = itemView.findViewById(R.id.textView4);
            location = itemView.findViewById(R.id.location);
            rating = itemView.findViewById(R.id.textView5);
        }
    }
}
