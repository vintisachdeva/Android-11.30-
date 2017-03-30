package com.bmpl.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView; //reference variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step-1
        //reference--> Downcasting
        //R--> Predefined class--> elements id
               textView = (TextView)findViewById(R.id.myTextView);

                textView.setText("Your application is running");
    }
}
