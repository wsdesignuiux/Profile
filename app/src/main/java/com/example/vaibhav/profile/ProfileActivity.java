package com.example.vaibhav.profile;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.ProfileAdapter;
import model.ProfileModel;

public class ProfileActivity extends AppCompatActivity {
    private ProfileAdapter profileAdapter;
    private RecyclerView recyclerview;
    private ArrayList<ProfileModel> profileModelArrayList;

    String txtmyreceived[]={"My received","Favorites","Shared products","Wishlist","Alerts","Liked items"};
    String txtn1[]={"314","987","65","132","324","230"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerview = findViewById(R.id.recyclerview1);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(ProfileActivity.this,2);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        profileModelArrayList = new ArrayList<>();

        for (int i = 0; i < txtmyreceived.length; i++) {
            ProfileModel view = new ProfileModel(txtmyreceived[i],txtn1[i]);
            profileModelArrayList.add(view);
        }
        profileAdapter = new ProfileAdapter(ProfileActivity.this,profileModelArrayList);
        recyclerview.setAdapter(profileAdapter);
    }
}
