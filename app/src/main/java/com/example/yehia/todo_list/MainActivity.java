package com.example.yehia.todo_list;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
ArrayList<String> tasks = new ArrayList<>();
 String taskname = getIntent().getStringExtra("name") ;
    String recive = getIntent().getStringExtra("key");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        tasks.add(taskname);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,tasks);
        listView.setAdapter(arrayAdapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 int itemPosition     = position;
                 String  itemValue    = (String) listView.getItemAtPosition(position);
                 AlertDialog.Builder builder = new AlertDialog.Builder(null);
                 builder.setTitle("task " + itemValue);
                 builder.setMessage(recive);

                 // add a button
                 builder.setPositiveButton("OK", null);

                 // create and show the alert dialog
                 AlertDialog dialog = builder.create();
                 dialog.show();
             }
         });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
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
}
