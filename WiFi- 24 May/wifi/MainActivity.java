package com.bmpl.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = (Switch)findViewById(R.id.wifiSwitch);

        wifiManager = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(!b){
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Turned On", Toast.LENGTH_SHORT).show();
                }
                else if(b)
                {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Turned Off", Toast.LENGTH_SHORT).show();
                }

                /*if(!wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(true);
                }
                else if(wifiManager.isWifiEnabled())
                {
                    wifiManager.setWifiEnabled(false);
                }*/
            }
        });
    }
}