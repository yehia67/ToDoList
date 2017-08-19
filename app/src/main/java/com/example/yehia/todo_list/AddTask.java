package com.example.yehia.todo_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTask extends AppCompatActivity {
   EditText TaskDescripition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        TaskDescripition = (EditText) findViewById(R.id.ET_taskdescr);
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

            String getDesc = TaskDescripition.getText().toString();

            intent.putExtra("key",getDesc);

            startActivity(intent);
    }
}

}
