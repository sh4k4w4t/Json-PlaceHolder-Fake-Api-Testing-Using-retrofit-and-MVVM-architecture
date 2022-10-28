package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.CommentModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitInstance;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryImpl implements Repository{
    private static Context context;
    private List<CommentModel> commentModels;
    private MutableLiveData mutableLiveData;
    RetrofitServices services;

    private static RepositoryImpl instance;
    public static RepositoryImpl getInstance(Context mcontext) {
        if (instance==null){
            mcontext=context;
            instance= new RepositoryImpl();
        }
        return instance;
    }

    @Override
    public MutableLiveData<List<CommentModel>> getAllCommentlist() {
        if (mutableLiveData==null){
            mutableLiveData= new MutableLiveData();
        }
        services= RetrofitInstance.getServices();
        Call<List<CommentModel>> call= services.getAllCommentList();
        call.clone().enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                commentModels= response.body();
                mutableLiveData.postValue(commentModels);
                Log.d("TAG", "onResponse: Success");
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Log.d("TAG", "onFailure: Failed");
            }
        });

        return mutableLiveData;
    }
}
