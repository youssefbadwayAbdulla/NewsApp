package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.newsapp.Models.Article;

import java.util.List;

public class NewsAdapters extends RecyclerView.Adapter<NewsAdapters.NewsHolder> {
    List<Article> articleList;

    public NewsAdapters(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        Article article = articleList.get(position);
        holder.textView.setText(article.getTitle());
        Glide.with(holder.itemView).load(article.getUrlToImage()).placeholder(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_news);
            textView = itemView.findViewById(R.id.tv_news);
        }
    }
}
