package com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.TodosModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.TodosRepository;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.TodosRepositoryImple;

import java.util.List;

public class TodosVM extends AndroidViewModel {
    TodosRepository todosRepository;


    public TodosVM(@NonNull Application application) {
        super(application);
        todosRepository= TodosRepositoryImple.getInstance(application);
    }

    public MutableLiveData<List<TodosModel>> allTOdos(){
        return todosRepository.getAllTodos();
    }
}
