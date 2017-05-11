package com.bmpl.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String data[]={"Data1", "Data2", "Data3", "Data4", "Data5", "Data6", "Data7", "Data8", "Data9", "Data10"
            , "Data7", "Data8", "Data9", "Data10" , "Data7", "Data8", "Data9", "Data10"};
    ArrayAdapter arrayAdapter;//baseadpter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        //adapter

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, data);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selected = data[position];
                Log.i("MainActivity", selected);
                Toast.makeText(MainActivity.this, "You clicked on " + position + " item " + selected  ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
