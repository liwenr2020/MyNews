package com.example.mynews.web;

import android.util.Log;

import com.example.mynews.news.NewsItem;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExplainJson {

    private String json;
    public NewsItem newsItem;
    //private GetJson getJson;
    public List<NewsItem.T1348647853363DTO> getDataList(String data)  {
       // getJson=new GetJson();
//        json=getJson.getDetails();
        json=data;
        Gson gson=new Gson();
        newsItem=new NewsItem();
        newsItem=gson.fromJson(json,NewsItem.class);
        final List<NewsItem.T1348647853363DTO> datas;
        datas=newsItem.getT1348647853363();

        Log.e(">>>解析的标题",datas.get(0).getLtitle().toString());
        return  datas;
    }

}
