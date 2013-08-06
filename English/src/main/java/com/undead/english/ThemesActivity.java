package com.undead.english;

import android.app.ListActivity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.undead.english.adapters.TaskAdapter;
import com.undead.english.base.MyDatabase;

public class ThemesActivity extends ListActivity {

    private Cursor themes;
    private MyDatabase db;


    String[] names;
    String[] dates;
    Integer[] mImage = {R.drawable.aries, R.drawable.taurus,
            R.drawable.gemini, R.drawable.cancer,
            R.drawable.lion, R.drawable.virgo,
            R.drawable.libra, R.drawable.scorpio,
            R.drawable.sagittarius, R.drawable.capricorn,
            R.drawable.aquarius, R.drawable.pisces};

    TaskAdapter mAdapter;
    //private static final int NOTIFY_ID = 101;
    private NotificationManager myNotifyMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        names = getResources().getStringArray(R.array.tasklist_names);
        dates = getResources().getStringArray(R.array.tasklist_dates);

        db = new MyDatabase(this);
        themes = db.getThemes(); // you would not typically call this on the main thread

//        ListAdapter adapter = new SimpleCursorAdapter(this,
//                android.R.layout.simple_list_item_1,
//                themes,
//                new String[] {"FullName"},
//                new int[] {android.R.id.text1});
//
//        getListView().setAdapter(adapter);

        //mAdapter = new TaskAdapter(names, dates, mImage, this);

        mAdapter = new TaskAdapter(themes, this);
        setListAdapter(mAdapter);

        myNotifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.themes, menu);
        return true;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(this, WordsActivity.class);
        intent.putExtra("theme",position);
        startActivity(intent);
    }
}
