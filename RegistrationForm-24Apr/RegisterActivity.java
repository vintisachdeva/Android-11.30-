package com.bmpl.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner;
    Button createAccount;
    EditText nameEditText, emailEditText, passwordEditText;
    String spinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createAccount = (Button)findViewById(R.id.createAccountId);


        nameEditText = (EditText)findViewById(R.id.nameEditText);
        emailEditText = (EditText)findViewById(R.id.emailEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                spinnerValue = spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //listener
        createAccount.setOnClickListener(this);

    }
    //handler
    @Override
    public void onClick(View view) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        //source--> RegisterActivity
        //Destination--> WelcomeActivity
        Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
        intent.putExtra("userName", name);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("gender", spinnerValue);
        //start activity always open a new activity-->
        // it doesn't check whether the activity is already opened or not
        //startActivity(intent);//must to redirect to new activity otherwise new activity will never open
        //request code-->
        startActivityForResult(intent, 100);
    }
}