package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //step-1: Downcasting of all required widgets of xml into java
    //instance variables--> to access them globally
    EditText nameEditText, phoneEditText;

    Button submitButton, cancelButton;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //R--> automatically created class--> android
        nameEditText =  (EditText) findViewById(R.id.nameEditText);
        phoneEditText = (EditText)findViewById(R.id.phoneEditText);

        textView = (TextView)findViewById(R.id.resultTextView);

        submitButton = (Button)findViewById(R.id.submitButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);

        //event listener--> event handler
        submitButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

    }

    //event handler
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.submitButton:

                String name = nameEditText.getText().toString();
                String phn = phoneEditText.getText().toString();

                textView.setText("Welcome "+ name + " " + phn);

                break;

            case R.id.cancelButton:
                break;
        }
    }
}