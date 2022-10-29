package com.shakawat.jsonplaceholderapitestusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.TodosModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.Adapter.TodosAdapter;
import com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel.TodosVM;
import com.shakawat.jsonplaceholderapitestusingmvvm.databinding.ActivityToDosBinding;

import java.util.List;

public class ToDos extends AppCompatActivity {
    RecyclerView recyclerView;
    ActivityToDosBinding binding;
    TodosVM vm;
    TodosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityToDosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView= binding.recycleViewTodos;
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        vm= new ViewModelProvider(this).get(TodosVM.class);
        vm.allTOdos().observe(this, new Observer<List<TodosModel>>() {
            @Override
            public void onChanged(List<TodosModel> todosModels) {
                adapter= new TodosAdapter(ToDos.this,todosModels);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}