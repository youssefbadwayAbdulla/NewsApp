package com.example.newsapp;

import com.example.newsapp.Models.NewRespons;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {
    @GET("v2/top-headlines?country=eg&category=business&apiKey=70bb926a044d4c7aa08668f5ff7c114e")
    Call<NewRespons>getNews();

    @GET("v2/top-headlines?apiKey=70bb926a044d4c7aa08668f5ff7c114e")
    Call<NewRespons>getNews(@Query("country")String country,
                            @Query("category")String category);
}
