package com.example.strogeoption1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }
    public void createTask(View v){
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }
}