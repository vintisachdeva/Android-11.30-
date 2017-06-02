package com.bmpl.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button saveButton, readButton;
    EditText nameEditText, salaryEditText;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button)findViewById(R.id.saveButton);
        readButton = (Button)findViewById(R.id.readButton);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        salaryEditText = (EditText)findViewById(R.id.salaryEditText);

        saveButton.setOnClickListener(this);
        readButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.saveButton:

                String name = nameEditText.getText().toString();
                String salary = salaryEditText.getText().toString();

                    //string name=name of our file
                    //int mode= in which mode--> MODE_PRIVATE--> Overwrite, MODE_APPEND-->

                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(openFileOutput("user", MODE_APPEND)));
                    bufferedWriter.write(name+"\n");
                    bufferedWriter.write(salary);

                    bufferedWriter.close();

                    Toast.makeText(MainActivity.this, "Data Created", Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;


            case R.id.readButton:

                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(openFileInput("user")));

                    String data;
                    while ((data = bufferedReader.readLine())!=null){
                        Log.d("MainActivity", data);
                        Toast.makeText(MainActivity.this,"Data is = "+data, Toast.LENGTH_LONG).show();
                    }

                    //For Reading Single Line
                    /*String userName = bufferedReader.readLine().toString();
                    Log.d("MainActivity", userName);
                    Toast.makeText(MainActivity.this,"Data is = "+userName, Toast.LENGTH_LONG).show();*/

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}