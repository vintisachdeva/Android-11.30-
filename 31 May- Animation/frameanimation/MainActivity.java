package com.bmpl.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    AnimationDrawable animationDrawable;//Frame Animation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.frame_anim);

        animationDrawable = (AnimationDrawable) imageView.getBackground();

        animationDrawable.start();

    }
}
