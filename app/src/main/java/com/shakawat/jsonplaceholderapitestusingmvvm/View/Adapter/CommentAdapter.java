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
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.CommentModel;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.mViewHolder>{

    Context context;
    List<CommentModel> commentModels;

    public CommentAdapter(Context context, List<CommentModel> commentModels) {
        this.context = context;
        this.commentModels = commentModels;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new mViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout_for_comments,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.postID.setText(commentModels.get(position).getPostId()+"");
        holder.id.setText(commentModels.get(position).getId()+"");
        holder.name.setText(commentModels.get(position).getName()+"");
        holder.email.setText(commentModels.get(position).getEmail()+"");
        holder.body.setText(commentModels.get(position).getBody()+"");
    }

    @Override
    public int getItemCount() {
        return commentModels.size();
    }


    public static class mViewHolder extends RecyclerView.ViewHolder{
        TextView postID,id,name,email,body;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            postID= itemView.findViewById(R.id.postIDComment);
            id= itemView.findViewById(R.id.idComment);
            name= itemView.findViewById(R.id.nameComment);
            email= itemView.findViewById(R.id.emailComment);
            body= itemView.findViewById(R.id.bodyComment);
        }
    }
}
