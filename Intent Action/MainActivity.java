package com.bmpl.intentactionnikchan;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button)findViewById(R.id.sendButton);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to perform an action
                //Intent Action --> Implicit intents

                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text");
                    intent.putExtra(Intent.EXTRA_TEXT, "This is my app data");
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "No app to support data", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}