package com.undead.english.base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.SimpleCursorAdapter;

import com.undead.english.model.Word;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.undead.english.base.BaseConstants.TABLE_THEME;
import static com.undead.english.base.BaseConstants.TABLE_WORDS;
import static com.undead.english.base.BaseConstants.THEME_ENG;
import static com.undead.english.base.BaseConstants.THEME_PICTURE;
import static com.undead.english.base.BaseConstants.THEME_RUS;
import static com.undead.english.base.BaseConstants.WORD_ENG;
import static com.undead.english.base.BaseConstants.WORD_RUS;
import static com.undead.english.base.BaseConstants.WORD_THEME;

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "english";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getThemes() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"0 " + _ID, THEME_ENG, THEME_RUS, THEME_PICTURE};
        String sqlTables = TABLE_THEME;

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);

        c.moveToFirst();
        return c;

    }

    public Cursor getWords() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"0 " + _ID, WORD_ENG, WORD_RUS, WORD_THEME};
        String sqlTables = TABLE_WORDS;

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null, null, null, null);

        c.moveToFirst();
        return c;

    }

    public List<Word> getWords(int theme) {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {_ID, WORD_ENG, WORD_RUS, WORD_THEME};
        String sqlTables = TABLE_WORDS;
        String selection = WORD_THEME + " = " + theme;

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, selection, null, null, null, null);

        c.moveToPrevious();
        List<Word> words = new ArrayList<Word>();
        while (c.moveToNext()){
            Word word = new Word();
            word.set_id(c.getInt(0));
            word.setWordEng(c.getString(1));
            word.setWordRus(c.getString(2));
            word.setTheme(c.getInt(3));
            words.add(word);
        }
        return words;

    }

//    public static String[] FROM = {_ID, TIME, TITLE};
//    public static String ORDER_BY = TIME + " DESC";
//
//    public Cursor getEvents() {
//        return managedQuery(CONTENT_URI, FROM, null, null, ORDER_BY);
//    }
//
//    private static int[] TO = {R.id.rowid, R.id.time, R.id.title,};
//
//    public void showEvents(Cursor cursor) {
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
//                R.layout.item, cursor, FROM, TO);
//        setListAdapter(adapter);
//    }
//
//    public Cursor getWords() {
//
//        SQLiteDatabase db = getReadableDatabase();
//        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
//
//        String [] sqlSelect = {"0 _id", "FullName"};
//        String sqlTables = "Employees";
//
//        qb.setTables(sqlTables);
//        Cursor c = qb.query(db, sqlSelect, null, null,
//                null, null, null);
//
//        c.moveToFirst();
//        return c;
//
//    }

}
