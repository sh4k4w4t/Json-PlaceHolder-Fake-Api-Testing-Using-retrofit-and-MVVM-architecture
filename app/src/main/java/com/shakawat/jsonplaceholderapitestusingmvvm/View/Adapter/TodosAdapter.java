package com.shakawat.jsonplaceholderapitestusingmvvm.View.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.TodosModel;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.xViewHolder>{
    private Context context;
    private List<TodosModel> todosModels;

    public TodosAdapter(Context context, List<TodosModel> todosModels) {
        this.context = context;
        this.todosModels = todosModels;
    }

    @NonNull
    @Override
    public xViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new xViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout_todods,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull xViewHolder holder, int position) {
        holder.userId.setText(todosModels.get(position).getUserId()+"");
        holder.id.setText(todosModels.get(position).getId()+"");
        holder.title.setText(todosModels.get(position).getTitle()+"");
        holder.complete.setText(todosModels.get(position).getCompleted()+"");
        if (todosModels.get(position).getId()%2==0){
            holder.linearLayout.setBackgroundColor(Color.GREEN);
        }else {
            holder.linearLayout.setBackgroundColor(Color.MAGENTA);
        }
    }

    @Override
    public int getItemCount() {
        return todosModels.size();
    }

    protected static class xViewHolder extends RecyclerView.ViewHolder{
        TextView userId, id, title, complete;
        LinearLayout linearLayout;

        public xViewHolder(@NonNull View itemView) {
            super(itemView);
            userId= itemView.findViewById(R.id.userIdTodos);
            id= itemView.findViewById(R.id.idTodos);
            title= itemView.findViewById(R.id.titleTodos);
            complete= itemView.findViewById(R.id.completeTodos);
            linearLayout=itemView.findViewById(R.id.todosLayout);
        }
    }
}
