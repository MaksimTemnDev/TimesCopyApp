package com.example.timescopy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class Storage_Of_MainTXT extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Articles";
    public static final String TABLE_ARTICLES = "Articles";

    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE= "_id";
    public static final String KEY_ARTICLE = "_id";

    public Storage_Of_MainTXT(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_ARTICLES + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text," + KEY_ARTICLE + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_ARTICLES);

        onCreate(db);
    }
}


