package com.bmpl.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Button createAccount;
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createAccount = (Button)findViewById(R.id.createAccountId);

        nameEditText = (EditText)findViewById(R.id.nameEditText);

        //listener
        createAccount.setOnClickListener(this);
    }
    //handler
    @Override
    public void onClick(View view) {

        String name = nameEditText.getText().toString();

        //source--> RegisterActivity
        //Destination--> WelcomeActivity
        Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
        intent.putExtra("userName", name);
        startActivity(intent);//must to redirect to new activity otherwise new activity will never open

    }
}