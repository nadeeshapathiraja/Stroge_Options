package com.example.strogeoption1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TaskHelper extends SQLiteOpenHelper {


     public TaskHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "dbtasks", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
         //Genarate Query
        String sql1 = "CREATE TABLE tasks (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, date DATE, complete BOOLEAN)";
        //pass query to db
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
