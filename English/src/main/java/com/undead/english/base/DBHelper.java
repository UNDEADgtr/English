//package com.undead.english.base;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import static android.provider.BaseColumns._ID;
//import static com.undead.english.base.BaseConstants.TABLE_NAME;
//import static com.undead.english.base.BaseConstants.TIME;
//import static com.undead.english.base.BaseConstants.TITLE;
//
///**
// * Created by Lenovo on 30.06.13.
// */
//public class DBHelper extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "events.db" ;
//    private static final int DATABASE_VERSION = 1;
//
//    public DBHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//        TIME + " INTEGER, " + TITLE + " TEXT NOT NULL);");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
//        onCreate(sqLiteDatabase);
//    }
//}
