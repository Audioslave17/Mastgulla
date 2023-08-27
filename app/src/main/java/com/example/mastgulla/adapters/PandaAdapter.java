package com.example.mastgulla.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mastgulla.R;
import com.example.mastgulla.models.PandaModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class PandaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private BottomSheetDialog bottomSheetDialog;
    Context context;
    List<PandaModel> list;

    public PandaAdapter(Context context, List<PandaModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PandaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PandaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.offers,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final String mName = list.get(position).getName();
        final String mRating = list.get(position).getRating();
        final String mPrice = list.get(position).getPrice();
        final int mImage = list.get(position).getImage();

        if(holder instanceof PandaViewHolder) {
            ((PandaViewHolder) holder).roundedImageView.setImageResource(list.get(position).getImage());
            ((PandaViewHolder) holder).name.setText(list.get(position).getName());
            ((PandaViewHolder) holder).rating.setText(list.get(position).getRating());
            ((PandaViewHolder) holder).price.setText(list.get(position).getPrice());
        }

        ((PandaViewHolder) holder).roundedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);

                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
                sheetView.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_name);
                TextView bottomPrice = sheetView.findViewById(R.id.bottom_price);
                TextView bottomRating = sheetView.findViewById(R.id.bottom_rating);

                bottomName.setText(mName);
                bottomPrice.setText(mPrice);
                bottomRating.setText(mRating);
                bottomImg.setImageResource(mImage);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PandaViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView roundedImageView;
        TextView name,rating, price;

        public PandaViewHolder(View itemView) {
            super(itemView);

            roundedImageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            rating = itemView.findViewById(R.id.detailed_rating);
            price = itemView.findViewById(R.id.textView6);
        }
    }
}
