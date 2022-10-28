package com.shakawat.jsonplaceholderapitestusingmvvm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.CommentModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.Repository;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Repository.RepositoryImpl;

import java.util.List;

public class CommentViewModel extends AndroidViewModel {
    Repository repo;

    public CommentViewModel(@NonNull Application application) {
        super(application);
        repo= RepositoryImpl.getInstance(application);
    }

    public MutableLiveData<List<CommentModel>> getAllCommentList(){
        return repo.getAllCommentlist();
    }
}
