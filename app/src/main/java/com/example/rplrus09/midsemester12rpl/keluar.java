package com.example.rplrus09.midsemester12rpl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class keluar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("masuk", Context.MODE_PRIVATE);
        String user = sharedPreferences.getString("user", "");
        if (user.equals("")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("isLogged", 1);
            editor.apply();
            finish();
            Intent intent = new Intent(keluar.this, MainActivity.class);
            startActivity(intent);

        } else if (user == user){
            Intent intent = new Intent(keluar.this, Home.class);
            startActivity(intent);
            finish();
        }


    }
}

