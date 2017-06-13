package com.bmpl.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    Button button, secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        secondButton = (Button)findViewById(R.id.buttonOne);

        webView = (WebView)findViewById(R.id.webView);

        button.setOnClickListener(this);
        secondButton.setOnClickListener(this);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                webView.loadUrl("https://www.google.co.in/");

                webView.getSettings().setJavaScriptEnabled(true);
                webView.clearHistory();

            }
        });*/


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button:

                webView.loadUrl("https://www.google.co.in/");

                webView.getSettings().setJavaScriptEnabled(true);
                webView.clearHistory();

                break;

            case R.id.buttonOne:
                break;
        }
    }
}