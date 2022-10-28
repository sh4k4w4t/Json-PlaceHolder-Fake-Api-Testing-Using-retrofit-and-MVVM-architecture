package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.PostsModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitInstance;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepositoryImplementation implements PostsRepository{
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private List<PostsModel> postsModelList;
    private MutableLiveData mLiveData;

    @SuppressLint("StaticFieldLeak")
    private static PostRepositoryImplementation instance;
    public static PostRepositoryImplementation getInstance(Context mContext){
        if (instance==null){
            mContext=context;
            instance= new PostRepositoryImplementation();
        }
        return instance;
    }

    @Override
    public MutableLiveData<List<PostsModel>> getPostsList() {
        if (mLiveData==null){
            mLiveData= new MutableLiveData();
        }
        RetrofitServices services= RetrofitInstance.getRetrofit().create(RetrofitServices.class);
        Call<List<PostsModel>> call= services.responsePosts();
        call.enqueue(new Callback<List<PostsModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostsModel>> call, @NonNull Response<List<PostsModel>> response) {
                postsModelList = response.body();
                mLiveData.postValue(postsModelList);
                Log.d("TAG", "onResponse: Success=============");
            }

            @Override
            public void onFailure(@NonNull Call<List<PostsModel>> call, @NonNull Throwable t) {
                Log.d("TAG", "onFailure: Failed==========");
            }
        });
        return mLiveData;
    }
}
