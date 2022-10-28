package com.shakawat.jsonplaceholderapitestusingmvvm.View.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.PostsModel;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostHolder>{
    Context context;
    List<PostsModel> postsModelList;

    public PostsAdapter(Context context, List<PostsModel> postsModelList) {
        this.context = context;
        this.postsModelList = postsModelList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout_posts_recycleview,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.userId.setText(postsModelList.get(position).getUserId()+"");
        holder.id.setText(postsModelList.get(position).getId()+"");
        holder.title.setText(postsModelList.get(position).getTitle()+"");
        holder.body.setText(postsModelList.get(position).getBody()+"");
    }

    @Override
    public int getItemCount() {
        return postsModelList.size();
    }

    public static class PostHolder extends RecyclerView.ViewHolder{
        TextView userId,id,title,body;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            userId= itemView.findViewById(R.id.textViewUserId);
            id= itemView.findViewById(R.id.textViewId);
            title= itemView.findViewById(R.id.textViewTitle);
            body= itemView.findViewById(R.id.textViewBody);
        }
    }
}
