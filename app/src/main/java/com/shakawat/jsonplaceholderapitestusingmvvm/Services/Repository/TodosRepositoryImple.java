package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.TodosModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitInstance;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosRepositoryImple implements TodosRepository{
    private static Context context;
    private List<TodosModel> todosModels;
    private MutableLiveData todosLiveData;

    private static TodosRepositoryImple instance;
    public static TodosRepositoryImple getInstance(Context mContext){
        if (instance==null){
            mContext=context;
            instance= new TodosRepositoryImple();
        }
        return instance;
    }

    @Override
    public MutableLiveData<List<TodosModel>> getAllTodos() {
        if (todosLiveData==null){
            todosLiveData= new MutableLiveData();
        }
        RetrofitServices retrofitServices= RetrofitInstance.getServices();
        Call<List<TodosModel>> call= retrofitServices.getAllTodosList();
        call.clone().enqueue(new Callback<List<TodosModel>>() {
            @Override
            public void onResponse(Call<List<TodosModel>> call, Response<List<TodosModel>> response) {
                todosModels= response.body();
                todosLiveData.postValue(todosModels);
                Log.d("TAG", "onResponse: Success TODOS");
            }

            @Override
            public void onFailure(Call<List<TodosModel>> call, Throwable t) {
                Log.d("TAG", "onFailure: Failed TODOS");
            }
        });
        return todosLiveData;
    }
}
