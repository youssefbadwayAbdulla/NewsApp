package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsapp.Models.NewRespons;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//https://newsapi.org/v2/top-headlines?country=eg&category=business&apiKey=70bb926a044d4c7aa08668f5ff7c114e
//baseUrl:https://newsapi.org/
//endpoint:v2/top-headlines?country=eg&category=business&apiKey=70bb926a044d4c7aa08668f5ff7c114e
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    NewsAdapters newsAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rc_view_news);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Apis apis = retrofit.create(Apis.class);
        apis.getNews("eg", "sports").enqueue(new Callback<NewRespons>() {
            @Override
            public void onResponse(Call<NewRespons> call, Response<NewRespons> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().getArticles().size());

                    newsAdapters=new NewsAdapters(response.body().getArticles());
                    recyclerView.setAdapter(newsAdapters);

                }
            }

            @Override
            public void onFailure(Call<NewRespons> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());

            }
        });
    }
}