package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network;

import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.CommentModel;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.Comments_postId_1Model;
import com.shakawat.jsonplaceholderapitestusingmvvm.Services.Model.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServices {

    @GET("/posts")
    Call<List<PostsModel>> responsePosts();

    @GET("/comments?postId=1")
    Call<List<Comments_postId_1Model>> responseComment_postId_1List();

    @GET("/comments")
    Call<List<CommentModel>> getAllCommentList();
}
