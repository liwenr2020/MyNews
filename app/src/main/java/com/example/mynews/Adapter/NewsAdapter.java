package com.example.mynews.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynews.MainActivity;
import com.example.mynews.NewsInfoActivity;
import com.example.mynews.R;
import com.example.mynews.news.NewsItem;

import java.net.URL;
import java.util.List;



public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<NewsItem.T1348647853363DTO> mNewsList;
    private LayoutInflater mLayoutInflater;

    public NewsAdapter(List<NewsItem.T1348647853363DTO> data,
           LayoutInflater l){
        mNewsList=data;
        mLayoutInflater=l;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  mLayoutInflater.inflate(R.layout.news_item,parent,false);

        return new NewsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        String image = mNewsList.get(position).getImgsrc();
        String title =mNewsList.get(position).getTitle();

        Glide.with(holder.itemView.getContext()).load(image).into(holder.imageView);
        holder.textView.setText(title);

        holder.linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewsInfoActivity.class);

                    String url = mNewsList.get(position).getUrl();//.replace('|', '/');
                    //String newUrl = "https://news.163.com/photoview/" + url + ".html";

                    intent.putExtra("url", url);
                    v.getContext().startActivity(intent);
                Log.e(">>>>>","你点击了");
            }
        });
    }

    //    public NewsAdapter(List<NewsItem.T1348647853363DTO> mNewsList,LayoutInflater l){
//        this.mNewsList=mNewsList;
//        layoutInflater=l;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view= layoutInflater.inflate(R.layout.news_item,parent,false);
//        RecyclerView.ViewHolder holder=new RecyclerView.ViewHolder(view);
//        return holder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//       // NewsItem.T1348647853363DTO t1348647853363DTO = mNewsList.get(position);
//
////        int i = 0;
////
////        do {
//            String image = mNewsList.get(position).getImgsrc();
//            String title =mNewsList.get(position).getTitle();
//
//            Glide.with(holder.itemView.getContext()).load(image).into(holder.imageView);
//            holder.textView.setText(title);
//
//            //NewsItem.T1348647853363DTO.AdsDTO finalAdsDTO = adsDTO;
////            int finalI = i;
//            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), NewsInfoActivity.class);
//
//                    String url = mNewsList.get(position).getUrl();//.replace('|', '/');
//                    //String newUrl = "https://news.163.com/photoview/" + url + ".html";
//
//                    intent.putExtra("url", url);
//                    v.getContext().startActivity(intent);
//
//                }
//            });
////            i=i+1;
////        }while(mNewsList.get(i)!=null);
//    }
    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

//    private static class NewsViewHolder extends RecyclerView.ViewHolder{
//        ImageView imageView;
//         TextView textView;
//         LinearLayout linearLayout;
//
//        @SuppressLint("ResourceType")
//        public NewsViewHolder(View view){
//            super(view);
//            imageView.findViewById(R.id.img_of_item);
//            textView.findViewById(R.id.details_of_item);
//            linearLayout.findViewById(R.layout.news_item);
//        }
//    }


}
