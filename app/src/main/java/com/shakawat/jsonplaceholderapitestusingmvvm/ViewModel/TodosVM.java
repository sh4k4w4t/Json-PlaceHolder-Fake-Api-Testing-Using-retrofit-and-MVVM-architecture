package com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

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

    public void SetToast(Context context,String text){
        Toast.makeText(context, text+"", Toast.LENGTH_SHORT).show();
    }

    public int setProgress(int visibility){
        return visibility;
    }
}
