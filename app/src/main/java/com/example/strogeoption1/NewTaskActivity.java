package com.example.strogeoption1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class NewTaskActivity extends AppCompatActivity {

    EditText etname;
    DatePicker taskDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        etname = findViewById(R.id.taskname);
        taskDate = findViewById(R.id.datePicker);
    }

    public void save(View v){
        String name = etname.getText().toString();
        String date = taskDate.toString();

        //Step 1. Create openHelper object with context passed
        TaskHelper dbhelper = new TaskHelper(this,"dbtasks",null,1);

        //Step 2. Get Writeble database object
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        //Step 3. Create Insert SQL query
        String query = "INSERT INTO tasks (name,date,complete) VALUES ('"+name+"','"+date+"','0')";

        //Step 3. Execute Query
        db.execSQL(query);

        //Step 4. Give a Message
        Toast.makeText(this, "Save Successfully", Toast.LENGTH_SHORT).show();
        clear(v);


    }
    public void clear(View v){
        etname.setText("");
    }
}