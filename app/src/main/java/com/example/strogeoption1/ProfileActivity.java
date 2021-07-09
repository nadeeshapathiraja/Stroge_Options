package com.example.strogeoption1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    EditText edName, edEmail,edMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        edName = findViewById(R.id.name);
        edEmail = findViewById(R.id.email);
        edMobile = findViewById(R.id.mobile);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences profile = getSharedPreferences("profile",MODE_PRIVATE);

        //get data to string variables from storage
        String name = profile.getString("NAME","");
        String email = profile.getString("EMAIL","");
        String mobile = profile.getString("MOBILE","");

        //set data to edittext variables
        edName.setText(name);
        edEmail.setText(email);
        edMobile.setText(mobile);



    }

    public void clear(View v){
        edName.setText("");
        edEmail.setText("");
        edMobile.setText("");
    }
    public void save(View v){

        //Get Data and convert to string in input fields
        String name = edName.getText().toString();
        String email = edEmail.getText().toString();
        String mobile = edMobile.getText().toString();

        //create shared preferences for store data
        SharedPreferences profile = getSharedPreferences("profile",MODE_PRIVATE);
        SharedPreferences.Editor editor = profile.edit();

        //store key value pares
        editor.putString("NAME",name);
        editor.putString("EMAIL",email);
        editor.putString("MOBILE",name);

        //Save Data
        editor.commit();

        Toast.makeText(this, "SAVED PROFILE DATA SUCCESSFULLY.", Toast.LENGTH_SHORT).show();
    }
}