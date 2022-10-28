package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServices {

    @GET("/posts")
    Call<List<PostsModel>> responsePosts();
}
