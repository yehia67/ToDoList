package com.example.yehia.todo_list;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yehia on 20/08/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static  final String DatabaseName = "task.db";
    private static final int version = 1;


    public DBHelper(Context context, String DatabaseName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DatabaseName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String CREATE_TABLE = "CREATE TABLE "  + Contract.tasks.table + " (" +
                Contract.tasks._ID                + " INTEGER PRIMARY KEY, " +
                Contract.tasks.colume_desc+ " TEXT NOT NULL, " +
               Contract.tasks.colume_prior   + " INTEGER NOT NULL);";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("task onUpgrade");
    }
}
