package com.bmpl.registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button yesButton, noButton;
    TextView welcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTextView = (TextView)findViewById(R.id.welcomeTextView);
        yesButton = (Button)findViewById(R.id.yesButton);
        noButton = (Button)findViewById(R.id.noButton);

        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");
        String email = intent.getExtras().getString("email");
        String password = intent.getStringExtra("password");
        String gender = intent.getStringExtra("gender");
        welcomeTextView.setText("Welcome " + name + " " + email + " " + password + gender);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.yesButton:
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.noButton:

                break;
        }
    }
}
