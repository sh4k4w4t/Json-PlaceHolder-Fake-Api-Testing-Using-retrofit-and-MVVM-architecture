package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.AlbumModel;
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
    private List<AlbumModel> albumModels;
    private MutableLiveData commentLiveDate, albumLiveDate;
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
        if (commentLiveDate ==null){
            commentLiveDate = new MutableLiveData();
        }
        services= RetrofitInstance.getServices();
        Call<List<CommentModel>> call= services.getAllCommentList();
        call.clone().enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                commentModels= response.body();
                commentLiveDate.postValue(commentModels);
                Log.d("TAG", "onResponse - Comment: Success");
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                Log.d("TAG", "onFailure - Comment: Failed");
            }
        });

        return commentLiveDate;
    }

    @Override
    public MutableLiveData<List<AlbumModel>> getAllAlbum() {
        if (albumLiveDate==null){
            albumLiveDate= new MutableLiveData();
        }
        services= RetrofitInstance.getServices();
        Call<List<AlbumModel>> call= services.getAllAlbumList();
        call.clone().enqueue(new Callback<List<AlbumModel>>() {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                albumModels= response.body();
                albumLiveDate.postValue(albumModels);
                Log.d("TAG", "onResponse - Album : Success");
            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable t) {
                Log.d("TAG", "onFailure - Album : Failed");

            }
        });
        return albumLiveDate;
    }
}
