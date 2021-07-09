package com.example.strogeoption1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences profile = getSharedPreferences("profile",MODE_PRIVATE);
        TextView title = findViewById(R.id.title);
        String name = profile.getString("NAME","Guest");
        title.setText("WELCOME "+name);
    }

    public void notes(View v){
        Intent intent = new Intent(this,NoteActivity.class);
        startActivity(intent);
    }
    public void task(View v){
        Intent intent = new Intent(this,TaskActivity.class);
        startActivity(intent);
    }
    public void expense(View v){
        Intent intent = new Intent(this,ExpenseActivity.class);
        startActivity(intent);
    }
    public void profile(View v){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }


}