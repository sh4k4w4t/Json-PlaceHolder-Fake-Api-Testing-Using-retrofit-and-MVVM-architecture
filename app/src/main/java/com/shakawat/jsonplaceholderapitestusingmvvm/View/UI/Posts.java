package com.shakawat.jsonplaceholderapitestusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.PostsModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.Adapter.PostsAdapter;
import com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel.PostsViewModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.databinding.ActivityPostsBinding;

import java.util.List;

public class Posts extends AppCompatActivity {
    ActivityPostsBinding binding;
    PostsViewModel pViewModel;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityPostsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.setTitle("Posts");

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        binding.recycleViewPosts.setLayoutManager(linearLayoutManager);

        pViewModel= new ViewModelProvider(this).get(PostsViewModel.class);
        pViewModel.getPostsList().observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                postsAdapter= new PostsAdapter(Posts.this,postsModels);
                binding.recycleViewPosts.setAdapter(postsAdapter);
            }
        });
    }
}