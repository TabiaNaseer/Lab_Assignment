package com.project.mycamp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Dashboard_Activity extends AppCompatActivity {
    CardView cardHome;
    CardView cardChat;
    CardView cardProfile;
    CardView cardWidget;
    CardView cardSettings;
    CardView cardLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardHome=findViewById(R.id.cardHome);
        cardChat=findViewById(R.id.cardChat);
        cardProfile=findViewById(R.id.cardProfile);
        cardWidget=findViewById(R.id.cardWidget);
        cardSettings=findViewById(R.id.cardSettings);
        cardLogout=findViewById(R.id.cardLogout);


        cardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Home Clicked");
            }
        });
        cardChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Chat Clicked");
            }
        });
        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Profile Clicked");
            }
        });
        cardWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Widget Clicked");
            }
        });
        cardSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Setting Clicked");
            }
        });
        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Logout");
            }
        });
        getSupportActionBar().hide();
    }
    private void showToast(String message){

        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }



}