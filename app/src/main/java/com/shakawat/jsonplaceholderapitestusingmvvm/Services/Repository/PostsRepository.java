package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.PostsModel;

import java.util.List;

public interface PostsRepository {
    public MutableLiveData<List<PostsModel>> getPostsList();
}
