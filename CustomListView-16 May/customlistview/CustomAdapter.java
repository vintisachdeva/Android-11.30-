package com.bmpl.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    String data[];
    int images[];
    Context context;//data pass activity but current class is not an activity
    LayoutInflater layoutInflater;

    CustomAdapter(MainActivity mainActivity, String data[], int images[]){
        context = mainActivity;
        this.data = data;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return images.length;//no data will be visible if 0 is returned
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    //main method return view
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view =  layoutInflater.inflate(R.layout.custom_layout, null);

        TextView textView = (TextView)view.findViewById(R.id.textView);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        textView.setText(data[position]);
        imageView.setImageResource(images[position]);


        return view;
    }
}
