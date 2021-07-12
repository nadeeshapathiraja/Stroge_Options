package com.example.strogeoption1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

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




    }
    public void clear(View v){
        etname.setText("");
    }
}