package com.undead.english.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.undead.english.R;


public class TaskAdapter extends BaseAdapter {

    Cursor cursor;
    private LayoutInflater mLayoutInflater;

//    public TaskAdapter(Context ctx) {
//        mLayoutInflater = LayoutInflater.from(ctx);
//    }

    public TaskAdapter(Cursor cursor, Context ctx) {
        this.cursor = cursor;
        this.mLayoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    public Object getItem (int position) {
        return position;
    }

    public long getItemId (int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item, null);
        }
        //ImageView image = (ImageView)convertView.findViewById(R.id.Image);
        //image.setImageResource(images[position]);

        cursor.moveToPosition(position);

        TextView themeEng = (TextView)convertView.findViewById(R.id.Sign);
        themeEng.setText(cursor.getString(1));

        TextView themeRus = (TextView)convertView.findViewById(R.id.Date);
        themeRus.setText(cursor.getString(2));

        return convertView;
    }

//    public String getString (int position) {
//        return names[position] + " (" + dates[position] + ")";
//    }

//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if (convertView == null)
//            convertView = mLayoutInflater.inflate(R.layout.item, null);
//
//        ImageView image = (ImageView)convertView.findViewById(R.id.Image);
//        image.setImageResource(images[position]);
//
//        TextView sign = (TextView)convertView.findViewById(R.id.Sign);
//        sign.setText(names[position]);
//
//        TextView date = (TextView)convertView.findViewById(R.id.Date);
//        date.setText(dates[position]);
//        return convertView;
//    }

}
