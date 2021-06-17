# MyNews
一、简介

      这是我们Android课后布置的作业任务：写一个网易新闻阅读器（简陋版）

二、要求

      1、使用okhttp异步加载数据；

      2、使用recyclerView加载首页；

      3、使用webView将网页转化为手机端阅读的界面。

三、完成过程中遇到的问题：

      1、网页异步加载的问题
     
              在Android里面，主线程是不允许进行耗时操作的，这个时候，我们能就需要new一个新的线程来完成该耗时操作。
          
          这里网页的数据加载就是耗时操作，通过网络请求获得一个json数据。
          
          但是我在处理的过程中，将json转化为字符一直为空，最后发现有两个问题：
               
               （1）要在AndroidManifest.xml里面获取网络权限：
               
               android:networkSecurityConfig="@xml/network_security_config"
               
               <?xml version="1.0" encoding="utf-8"?>
                      <network-security-config>
                            <base-config cleartextTrafficPermitted="true" />
                      </network-security-config>
                      
                （2）网络请求的线程问题
                
                      注意：主线程里面不能进行耗时操作，同时子线程里面也不能进行UI操作。进行UI操作的时候需要返回主线程。
                      
                      另外，activity里面针对线程有一系列的自动处理机制，但是在一个普通类里面新建线程的话，就需要程序员操作。
      
      2、解析json
            
            这是我第一次对json进行解析操作，我使用的json获取的地址是老师提供的：
            
                  http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html
                  
            但是因为这个有点长，所以我并不是手动解析的，而是通过Gson工具进行解析，使用也非常简单，很方便。
            
      3、构造recyclerView显示主页
      
            （1）上一次在MyList项目中，因为考虑到备忘录条数不会太多，所以就用的ListView。但是这里面网络加载的内容可能比较多，
            处于节约内存的目的，就使用的是recyclerView。
            
            （2）recyclerView有几个重点，
            
                Adapter,Holder,LayoutInflater（布局服务,当XML布局资源被解析并转换成View对象时会用到。）
                
                private void init(List<NewsItem.T1348647853363DTO> data) {

                      mLayoutInflater =  getLayoutInflater();

                      mRecycler = findViewById(R.id.my_recycler);
                      mAdapter = new NewsAdapter(data,mLayoutInflater);
                      mRecycler.setAdapter(mAdapter);
                      LinearLayoutManager manager = new LinearLayoutManager(this);

                      mRecycler.setLayoutManager(manager);
                      int i=mAdapter.getItemCount();
                      Log.d(">>>>>>>", ""+i);
                  }
                  
                  
                  Adapter里面onBindViewHolder,onCreateViewHolder
                  
                   public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view =  mLayoutInflater.inflate(R.layout.news_item,parent,false);

                        return new NewsViewHolder(view);
                    }
                  
                  而onBindViewHolder，就是执行具体的显示之类的。我觉得Holder就是来操控每一个item的。
      
      3、webView将一个html包装成手机端显示
            
            这项技术代码只有几行，非常方便。实现代码的复用。
            
            webView.setWebViewClient(new WebViewClient());
            String url=getIntent().getStringExtra("url");
            webView.loadUrl(url);
                
                
                
                    
          
          

