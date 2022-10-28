package com.shakawat.jsonplaceholderapitestusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.CommentModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.Adapter.CommentAdapter;
import com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel.CommentViewModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.databinding.ActivityCommentsBinding;

import java.util.List;

public class Comments extends AppCompatActivity {
    ActivityCommentsBinding binding;
    Context context;
    CommentAdapter adapter;
    CommentViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityCommentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recycleViewIdComments.setLayoutManager(layoutManager);

        viewModel= new ViewModelProvider(this).get(CommentViewModel.class);
        viewModel.getAllCommentList().observe(this, new Observer<List<CommentModel>>() {
            @Override
            public void onChanged(List<CommentModel> commentModels) {
                adapter= new CommentAdapter(Comments.this,commentModels);
                binding.recycleViewIdComments.setAdapter(adapter);
            }
        });
    }
}