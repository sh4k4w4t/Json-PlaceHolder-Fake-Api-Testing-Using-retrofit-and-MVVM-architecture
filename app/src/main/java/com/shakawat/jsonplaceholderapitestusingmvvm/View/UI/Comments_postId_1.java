package com.shakawat.jsonplaceholderapitestusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.Comments_postId_1Model;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.Adapter.Comments_postId_1Adapter;
import com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel.Comments_postId_1ViewModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.databinding.ActivityCommentsPostId1Binding;

import java.util.List;

public class Comments_postId_1 extends AppCompatActivity {
    ActivityCommentsPostId1Binding binding;
    Comments_postId_1Adapter adapter;
    Comments_postId_1ViewModel viewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityCommentsPostId1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.setTitle("Comments_postId_1");

        recyclerView= binding.recycleCommentsPostId1;
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        viewModel= new ViewModelProvider(this).get(Comments_postId_1ViewModel.class);
        viewModel.getCommentPostId1List().observe(this, new Observer<List<Comments_postId_1Model>>() {
            @Override
            public void onChanged(List<Comments_postId_1Model> comments_postId_1Models) {
                adapter= new Comments_postId_1Adapter(Comments_postId_1.this,comments_postId_1Models);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}