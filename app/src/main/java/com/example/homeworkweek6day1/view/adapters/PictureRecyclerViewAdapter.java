package com.example.homeworkweek6day1.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.homeworkweek6day1.R;
import com.example.homeworkweek6day1.model.user.Item;
import com.example.homeworkweek6day1.model.user.Media;
import com.example.homeworkweek6day1.model.user.UserResponse;

import java.util.List;

public class PictureRecyclerViewAdapter extends RecyclerView.Adapter<PictureRecyclerViewAdapter.ViewHolder>  {
    List<Item> resultList;

    public PictureRecyclerViewAdapter(UserResponse userResponse) {
        this.resultList = userResponse.getItems();
    }

    @NonNull
    @Override
    public PictureRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.picture_item, viewGroup, false));;
    }

    @Override
    public void onBindViewHolder(@NonNull PictureRecyclerViewAdapter.ViewHolder viewHolder, int i) {
        Item item = resultList.get(i);
        viewHolder.title.setText(item.getTitle());
        viewHolder.modified.setText(item.getDateTaken());
        Glide.with(this).load(item.getMedia().getM()).into(viewHolder.image);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView modified;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            modified = itemView.findViewById(R.id.tvModified);
            image = itemView.findViewById(R.id.imgPicture);

        }
    }
}
