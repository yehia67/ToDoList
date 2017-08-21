package com.example.yehia.todo_list;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity {
   EditText TaskDescripition;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> tasks = new ArrayList<>();
    String getDesc;
    private SQLiteDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        listView = (ListView) findViewById(R.id.lv);
        TaskDescripition = (EditText) findViewById(R.id.ET_taskdescr);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,tasks);
    }
public void Onclick(View view)
{
    switch (view.getId())
    {
        case R.id.bt_discard:
            startActivity(new Intent(this,MainActivity.class));
            break;
        case R.id.bt_save:
            Intent intent = new Intent(this,MainActivity.class);

             getDesc = TaskDescripition.getText().toString();

            addTask(getDesc);
            tasks.add(getDesc);
            listView.setAdapter(arrayAdapter);
            startActivity(intent);
    }
}
private long addTask(String n)
{
    ContentValues cv = new ContentValues();
    cv.put("daily task",getDesc);
    return mDb.insert(Contract.tasks.table,null,cv) ;
}
}
