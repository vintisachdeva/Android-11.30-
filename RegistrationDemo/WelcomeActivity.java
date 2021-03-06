package com.bmpl.registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class WelcomeActivity extends AppCompatActivity{

    TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTextView = (TextView)findViewById(R.id.welcomeTextView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");

        welcomeTextView.setText("Welcome " + name);
    }
}
