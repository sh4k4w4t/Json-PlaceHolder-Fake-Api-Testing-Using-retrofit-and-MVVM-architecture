package com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.PostsModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.PostRepositoryImplementation;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.PostsRepository;

import java.util.List;

public class PostsViewModel extends AndroidViewModel {
    private PostsRepository postsRepository;

    public PostsViewModel(@NonNull Application application) {
        super(application);
        postsRepository= PostRepositoryImplementation.getInstance(application);
    }

    public MutableLiveData<List<PostsModel>> getPostsList(){
        return postsRepository.getPostsList();
    }

}
