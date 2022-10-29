package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.TodosModel;

import java.util.List;

public interface TodosRepository {

    public MutableLiveData<List<TodosModel>> getAllTodos();
}
