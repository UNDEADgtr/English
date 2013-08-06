package com.undead.english;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnWords).setOnClickListener(this);
        findViewById(R.id.btnTopics).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWords: {
                startActivity(new Intent(this, ThemesActivity.class));
                break;
            }
            case R.id.btnTopics: {
                //startActivity(new Intent(this, AboutActivity.class));
                break;
            }
//            case R.id.btnAbout: {
//                startActivity(new Intent(this, AboutActivity.class));
//                break;
            }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        employees.close();
//        db.close();
//    }
    
}
