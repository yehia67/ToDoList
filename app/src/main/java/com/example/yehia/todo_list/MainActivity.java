package com.example.yehia.todo_list;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox height,meduim,low;
    SQLiteDatabase  mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final CheckBox  height =  (CheckBox) findViewById(R.id.ck_height);
        final CheckBox  meduim = (CheckBox) findViewById(R.id.ck_meduim);
        final CheckBox  low = (CheckBox) findViewById(R.id.ck_low);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private Cursor getAllGuests() {
        return mDb.query(
                Contract.tasks.table,
                null,
                null,
                null,
                null,
                null,
                Contract.tasks.colume_desc
        );
    }
    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.AB_add) {
            // do something here
            startActivity(new Intent(this,AddTask.class));
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean removeTask(long id) {

        return mDb.delete(Contract.tasks.table, Contract.tasks._ID + "=" + id, null) > 0;
    }
}
