package com.undead.english.model;

/**
 * Created by Lenovo on 18.07.13.
 */
public class Word {

    private int _id;
    private String wordEng;
    private String wordRus;
    private int theme;
    private String picture;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getWordEng() {
        return wordEng;
    }

    public void setWordEng(String wordEng) {
        this.wordEng = wordEng;
    }

    public String getWordRus() {
        return wordRus;
    }

    public void setWordRus(String wordRus) {
        this.wordRus = wordRus;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
