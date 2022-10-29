package com.shakawat.jsonplaceholderapitestusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.AlbumModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.Adapter.AlbumAdapter;
import com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel.ViewModels;
import com.shakawat.jsonplaceholderapitestusingmvvm.databinding.ActivityAlbumsBinding;

import java.util.List;

public class Albums extends AppCompatActivity {
    ActivityAlbumsBinding binding;
    ViewModels viewModels;
    AlbumAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAlbumsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView= binding.recycleViewAlbums;
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        viewModels= new ViewModelProvider(this).get(ViewModels.class);
        viewModels.getAllAlbumList().observe(this, new Observer<List<AlbumModel>>() {
            @Override
            public void onChanged(List<AlbumModel> albumModels) {
                adapter= new AlbumAdapter(Albums.this,albumModels);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}