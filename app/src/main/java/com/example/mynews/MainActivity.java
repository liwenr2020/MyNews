package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.mynews.Adapter.NewsAdapter;

import com.example.mynews.news.NewsItem;
import com.example.mynews.web.ExplainJson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private String NEWS_URL = "http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html";
    public String details;
    public List<NewsItem.T1348647853363DTO> data;
    private NewsAdapter mAdapter;
    private RecyclerView mRecycler;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        //initViews();
        GetJson();
        //ExplainJson explainJson=new ExplainJson();
//        Log.e(">>>>",details);
//        data=new ExplainJson().getDataList(details);
//        init(data);


    }
    private void init(List<NewsItem.T1348647853363DTO> data) {

        mLayoutInflater =  getLayoutInflater();

        mRecycler = findViewById(R.id.my_recycler);
        mAdapter = new NewsAdapter(data,mLayoutInflater);
        mRecycler.setAdapter(mAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        mRecycler.setLayoutManager(manager);
        int i=mAdapter.getItemCount();
        Log.e(">>>>>>>", ""+i);


    }

    public void GetJson() {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(NEWS_URL)
                                .build();

                        Response resp = client.newCall(request).execute();
                        ResponseBody body = resp.body();
                        details = body.string();
                        showResponse(details);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(NEWS_URL).build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                //...
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if(response.isSuccessful()){
//                    details = response.body().string();
//                    //处理UI需要切换到UI线程处理
//                }
//            }
//        });
        }

    private void showResponse(String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 在这里进行 UI 操作，将结果显示到界面上
                Log.e(">>>>",details);
                data=new ExplainJson().getDataList(details);
                init(data);Log.e("hello",">>>");
            }
        });
    }
    public String getDetails(){
        return details;
    }


//    private void initViews(){
//        //将viewpager和适配器绑在一起
//        viewPager=(ViewPager)findViewById(R.id.view_pager);
//        tablayout=(TabLayout)findViewById(R.id.tab_layout);
//
//        list=new ArrayList<>();
//        list.add(new FinanceFragment());
//        list.add(new SocialFragment());
//        list.add(new EntertainmentFragment());
//        list.add(new NationFragment());
//
//        mTitles=new ArrayList<>();
//        mTitles.add("经济");
//        mTitles.add("社会");
//        mTitles.add("娱乐");
//        mTitles.add("国际");
//
//       //传递数据
//        pagerAdapter=new MyFragmentPagerAdaptet(getSupportFragmentManager(),list,mTitles);
//        viewPager.setAdapter(pagerAdapter);
//
//        //将tablayout和viewPager绑在一起
//        tablayout.setupWithViewPager(viewPager);
//        }

}