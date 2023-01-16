package com.test.testaves.activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.test.testaves.R;
import com.test.testaves.datamodels.ImageDataModel;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder> {
    private final Context context;
    private final ArrayList<ImageDataModel> imageArrayList;

    public ImagesAdapter(Context context, ArrayList<ImageDataModel> imageArrayList) {
        this.context = context;
        this.imageArrayList = imageArrayList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ImageDataModel image = imageArrayList.get(position);

        if (image.getUser().getName() != null) {
            holder.nameTextV.setText(image.getUser().getName());
        } else
            holder.nameTextV.setText("User Name");

        if (image.getDescription() != null)
            holder.desTextV.setText(image.getDescription());
        else if (image.getAlt_description() != null)
            holder.desTextV.setText(image.getAlt_description());
        else
            holder.desTextV.setText("Description");

        Glide.with(context).load(image.getUrls().getRegular()).apply(new RequestOptions().placeholder(R.drawable.bulb_girl))
                .into(holder.sImageV);

        Glide.with(context).load(image.getUser().getProfile_image().getLarge()).apply(new RequestOptions().placeholder(R.drawable.user))
                .override(128, 128)
                .into(holder.pImageV);

        holder.sImageV.setOnClickListener(v -> {
            Intent i = new Intent(context, OpenedImageAct.class);
            i.putExtra("image", image);
            context.startActivity(i);
        });
        holder.view.setOnClickListener(v -> {
            Intent i = new Intent(context, ProfileActivity.class);
            i.putExtra("image", image.getUser());
            context.startActivity(i);
        });

    }

    @Override
    public int getItemCount() {
        if (imageArrayList != null) {
            return imageArrayList.size();
        } else return 0;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView sImageV;
        private final ImageView pImageV;
        private final TextView desTextV;
        private final TextView nameTextV;
        private final View view;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            sImageV = itemView.findViewById(R.id.imageView);
            pImageV = itemView.findViewById(R.id.profileImageView);
            desTextV = itemView.findViewById(R.id.imageDesText);
            nameTextV = itemView.findViewById(R.id.userName);
            view = itemView.findViewById(R.id.openProfile_ll);
        }
    }
}
