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
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.Comments_postId_1Model;

import java.util.List;

public class Comments_postId_1Adapter extends RecyclerView.Adapter<Comments_postId_1Adapter.mViewHolder>{
    Context context;
    List<Comments_postId_1Model> modelList;

    public Comments_postId_1Adapter(Context context, List<Comments_postId_1Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout_comments_postid_1,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.postId.setText(modelList.get(position).getPostId()+"");
        holder.id.setText(modelList.get(position).getId()+"");
        holder.name.setText(modelList.get(position).getName()+"");
        holder.email.setText(modelList.get(position).getEmail()+"");
        holder.body.setText(modelList.get(position).getBody()+"");
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class mViewHolder extends RecyclerView.ViewHolder{
        TextView postId,id,name,email,body;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            postId=itemView.findViewById(R.id.postId);
            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            body=itemView.findViewById(R.id.body);
        }
    }
}
