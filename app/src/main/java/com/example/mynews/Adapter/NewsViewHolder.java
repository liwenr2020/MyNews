package com.example.mynews.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.NewsInfoActivity;
import com.example.mynews.R;

public class NewsViewHolder extends RecyclerView.ViewHolder{
     ImageView imageView;
     TextView textView;
     LinearLayout linearLayout;

    @SuppressLint("ResourceType")
    public NewsViewHolder(View view){
        super(view);
//        name = itemView.findViewById(R.id.name);
//        price = itemView.findViewById(R.id.price);
        imageView=view.findViewById(R.id.img_of_item);
//        imageView=(ImageView)findViewById(R.id.img_of_item);
        textView=view.findViewById(R.id.details_of_item);
        linearLayout=view.findViewById(R.id.news_item);

    }
}
