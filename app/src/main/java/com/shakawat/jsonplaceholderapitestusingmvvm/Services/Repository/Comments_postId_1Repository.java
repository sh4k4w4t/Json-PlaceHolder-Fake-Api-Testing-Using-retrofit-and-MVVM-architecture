package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.Comments_postId_1Model;

import java.util.List;

public interface Comments_postId_1Repository {
    public MutableLiveData<List<Comments_postId_1Model>> getCommentsPostId1List();
}
