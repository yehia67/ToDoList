package com.example.yehia.todo_list;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.RecycleView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;
import com.example.yehia.todo_list.CustomCursorAdapter;
import java.util.ArrayList;

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
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
        // COMPLETED (8) Inside, get the viewHolder's itemView's tag and store in a long variable id
        //get the id of the item being swiped
        long id = (long) viewHolder.itemView.getTag();
        // COMPLETED (9) call removeGuest and pass through that id
        //remove from DB
        removeTask(id);
        // COMPLETED (10) call swapCursor on mAdapter passing in getAllGuests() as the argument
        //update the list
        TasksAdapter.swapCursor(getAllGuests());
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
    private int getPriorityColor(int priority) {
        int priorityColor = 0;

        switch(priority) {
            case 1: priorityColor = ContextCompat.getColor(mContext, R.color.materialRed);
                break;
            case 2: priorityColor = ContextCompat.getColor(mContext, R.color.materialOrange);
                break;
            case 3: priorityColor = ContextCompat.getColor(mContext, R.color.materialYellow);
                break;
            default: break;
        }
        return priorityColor;
    }