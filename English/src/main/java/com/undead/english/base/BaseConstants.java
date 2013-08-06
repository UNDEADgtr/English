package com.undead.english.base;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Lenovo on 30.06.13.
 */
public interface BaseConstants extends BaseColumns {

//    public static final String TABLE_NAME = "events";
//
//    public static final String TIME = "time";
//    public static final String TITLE = "title";

//    public static final String AUTHORITY = "by.undead.sqlitetest";
//    public static final Uri CONTENT_URI = Uri.parse("content://"
//            + AUTHORITY + "/" + TABLE_NAME);


    public static final String TABLE_THEME = "themes";
    public static final String THEME_ENG = "themeEng";
    public static final String THEME_RUS = "themeRus";
    public static final String THEME_PICTURE = "picture";


    public static final String TABLE_WORDS = "words";
    public static final String WORD_ENG = "wordEng";
    public static final String WORD_RUS = "wordRus";
    public static final String WORD_THEME = "theme";

}
