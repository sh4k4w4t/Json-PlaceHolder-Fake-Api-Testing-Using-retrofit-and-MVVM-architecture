package com.shakawat.jsonplaceholderapitestusingmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shakawat.jsonplaceholderapitestusingmvvm.View.UI.Albums;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.UI.Comments;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.UI.Comments_postId_1;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.UI.Photos;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.UI.Posts;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.UI.ToDos;
import com.shakawat.jsonplaceholderapitestusingmvvm.View.UI.Users;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ClickPost(View view) {
        startActivity(new Intent(getApplicationContext(), Posts.class));
    }

    public void ClickComments(View view) {
        startActivity(new Intent(getApplicationContext(), Comments.class));
    }

    public void ClickAlbums(View view) {
        startActivity(new Intent(getApplicationContext(), Albums.class));
    }

    public void ClickPhotos(View view) {
        startActivity(new Intent(getApplicationContext(), Photos.class));
    }

    public void ClickTodos(View view) {
        startActivity(new Intent(getApplicationContext(), ToDos.class));
    }

    public void ClickUsers(View view) {
        startActivity(new Intent(getApplicationContext(), Users.class));
    }

    public void ClickCommentsPostId1(View view) {
        startActivity(new Intent(getApplicationContext(), Comments_postId_1.class));
    }
}