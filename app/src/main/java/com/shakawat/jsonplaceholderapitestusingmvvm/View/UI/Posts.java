package com.shakawat.jsonplaceholderapitestusingmvvm.View.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shakawat.jsonplaceholderapitestusingmvvm.R;

public class Posts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        this.setTitle("Posts");
    }
}