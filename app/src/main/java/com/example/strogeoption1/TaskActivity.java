package com.example.strogeoption1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 1- Create dbhelper with context passed
        TaskHelper dbhelper = new TaskHelper(this,"dbtasks",null,1);

        //Step 2- Get SQLite database object
        SQLiteDatabase db = dbhelper.getReadableDatabase();

        //Step 3- Create Query
        String sql = "SELECT * FROM tasks";

        //Step 4- Execute and get the curser object
        Cursor cursor = db.rawQuery(sql, null);

        //Step 5- Create and empty list object
        List<String> list = new ArrayList<String>();

        //Step 6- Move cursewr and get data from list
        cursor.moveToFirst();

        //Step 7- check is it last item
        while (cursor.isAfterLast()==false){
            String name = cursor.getString(1);
            String date = cursor.getString(2);

            list.add(name+ " ("+date+")");
            cursor.moveToNext();
        }

        //Step 8- Get List view object
        ListView lv = findViewById(R.id.task_list);

//        //Step 9- Create adapter and set values to the list(Default view)
//        int layout = android.R.layout.simple_list_item_1;
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,layout,list);

        //Step 9-(User layout)
        int layout = R.layout.one_task;
        String []columns = {"name","date","id"};

        int[] lableSet = {R.id.taskname,R.id.task_date,R.id.task_id};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,layout,cursor,columns,lableSet);


        //Step 10- Set adapter to the list view
        lv.setAdapter(adapter);

    }

    public void createTask(View v){
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }
}