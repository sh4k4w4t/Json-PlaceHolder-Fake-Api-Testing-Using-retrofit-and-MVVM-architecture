package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.Comments_postId_1Model;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitInstance;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Comments_postId_1RepositoryImplementation implements Comments_postId_1Repository{
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private List<Comments_postId_1Model> listOfCommentPostModel1;
    private MutableLiveData mutableLiveData;
    private RetrofitServices services;

    @SuppressLint("StaticFieldLeak")
    private static Comments_postId_1RepositoryImplementation instance;
    public static Comments_postId_1RepositoryImplementation getInstance(Context context){
        if (instance==null){
            Comments_postId_1RepositoryImplementation.context =context;
            instance= new Comments_postId_1RepositoryImplementation();
        }
        return instance;
    }

    @Override
    public MutableLiveData<List<Comments_postId_1Model>> getCommentsPostId1List() {
        if (mutableLiveData==null){
            mutableLiveData= new MutableLiveData();
        }
        services= RetrofitInstance.getServices();
        Call<List<Comments_postId_1Model>> call= services.responseComment_postId_1List();
        call.clone().enqueue(new Callback<List<Comments_postId_1Model>>() {
            @Override
            public void onResponse(Call<List<Comments_postId_1Model>> call, Response<List<Comments_postId_1Model>> response) {
                listOfCommentPostModel1=response.body();
                mutableLiveData.postValue(listOfCommentPostModel1);
                Log.d("TAG", "onResponse: Success======");
            }

            @Override
            public void onFailure(Call<List<Comments_postId_1Model>> call, Throwable t) {
                Log.d("TAG", "onFailure: Failed =11=======");
            }
        });

        return mutableLiveData;
    }
}
