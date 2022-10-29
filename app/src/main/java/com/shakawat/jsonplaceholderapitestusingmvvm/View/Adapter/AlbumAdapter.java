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
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.AlbumModel;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.xViewHolder>{
    Context context;
    List<AlbumModel> albumModels;

    public AlbumAdapter(Context context, List<AlbumModel> albumModels) {
        this.context = context;
        this.albumModels = albumModels;
    }

    @NonNull
    @Override
    public xViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new xViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout_for_album,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull xViewHolder holder, int position) {
        holder.userId.setText(albumModels.get(position).getUserId()+"");
        holder.id.setText(albumModels.get(position).getId()+"");
        holder.title.setText(albumModels.get(position).getTitle()+"");
    }

    @Override
    public int getItemCount() {
        return albumModels.size();
    }

    protected static class xViewHolder extends RecyclerView.ViewHolder{
        TextView userId,id,title;

        public xViewHolder(@NonNull View itemView) {
            super(itemView);
            userId= itemView.findViewById(R.id.userIdAlbum);
            id= itemView.findViewById(R.id.idAlbum);
            title= itemView.findViewById(R.id.titleAlbum);
        }
    }
}
