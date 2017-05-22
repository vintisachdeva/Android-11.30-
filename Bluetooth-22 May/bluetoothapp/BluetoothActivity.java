package com.bmpl.bluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {

    Switch aSwitch;
    Button visibleButton, pairedDeviceButton;
    ListView listView;

    ArrayAdapter arrayAdapter;

    //remove duplicate elements
    Set<BluetoothDevice> bluetoothDevice;//information of all the paired devices

    BluetoothAdapter bluetoothAdapter; // default functionality --> active/disactive

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        aSwitch = (Switch)findViewById(R.id.switch1);
        visibleButton = (Button)findViewById(R.id.visibleButton);
        pairedDeviceButton = (Button)findViewById(R.id.pairedDevice);
        listView = (ListView)findViewById(R.id.listView);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //will call the bluetooth driver--> information

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(bluetoothAdapter == null){
                    Toast.makeText(BluetoothActivity.this, "Bluetooth Driver is not available", Toast.LENGTH_SHORT).show();
                }
                else if(!bluetoothAdapter.isEnabled())
                {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                    Toast.makeText(BluetoothActivity.this, "Turned On", Toast.LENGTH_SHORT).show();
                }
                else if(bluetoothAdapter.isEnabled()){
                    bluetoothAdapter.disable();
                    Toast.makeText(BluetoothActivity.this, "Turned Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        visibleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, "1000");//data pass from one activity to another activity
                startActivity(intent);
            }
        });

        pairedDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList arrayList = new ArrayList();

                bluetoothDevice = bluetoothAdapter.getBondedDevices();

                for(BluetoothDevice device:bluetoothDevice)
                {
                    arrayList.add(device.getName());
                }

                arrayAdapter = new ArrayAdapter(BluetoothActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList);

                listView.setAdapter(arrayAdapter);

                Toast.makeText(BluetoothActivity.this, "Paired Devices", Toast.LENGTH_LONG).show();

            }
        });
    }
}