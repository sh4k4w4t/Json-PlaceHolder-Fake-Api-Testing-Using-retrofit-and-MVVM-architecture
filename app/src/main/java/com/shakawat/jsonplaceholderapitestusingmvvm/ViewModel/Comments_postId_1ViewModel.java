package com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.Comments_postId_1Model;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.Comments_postId_1Repository;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.Comments_postId_1RepositoryImplementation;

import java.util.List;

public class Comments_postId_1ViewModel extends AndroidViewModel {
    Comments_postId_1Repository repository;

    public Comments_postId_1ViewModel(@NonNull Application application) {
        super(application);
        repository= Comments_postId_1RepositoryImplementation.getInstance(application);
    }

    public MutableLiveData<List<Comments_postId_1Model>> getCommentPostId1List(){
        return repository.getCommentsPostId1List();
    }
}
