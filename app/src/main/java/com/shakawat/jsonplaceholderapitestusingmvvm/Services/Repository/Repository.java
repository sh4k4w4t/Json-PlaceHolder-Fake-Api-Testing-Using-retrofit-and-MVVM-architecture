package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository;

import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.CommentModel;

import java.util.List;

public interface Repository {
    public MutableLiveData<List<CommentModel>> getAllCommentlist();
}
