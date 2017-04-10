package com.bmpl.imagechanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    //downcasting
    Button image1Button, image2Button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

    }


    void initialize()
    {
        image1Button = (Button)findViewById(R.id.image1Button);
        image2Button = (Button)findViewById(R.id.image2Button);
        imageView = (ImageView)findViewById(R.id.imageView);

        //step-2--> attach listener

        image1Button.setOnClickListener(this);
        image2Button.setOnClickListener(this);

    }

    //event handler
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(R.id.image1Button == id)
        {
            imageView.setImageResource(R.drawable.images1);
        }
        else if(R.id.image2Button == id)
        {
            imageView.setImageResource(R.drawable.images2);
        }

    }
}
