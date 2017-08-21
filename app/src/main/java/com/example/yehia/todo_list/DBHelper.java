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
     final String SQL_Create_table = String.format("task i should do",Contract.class);
        sqLiteDatabase.execSQL(SQL_Create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("task onUpgrade");
    }
}
