package com.example.rplrus09.midsemester12rpl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private  int MAIN_ACTIVITY_REQUEST_CODE ;
    EditText ednama,edpass;
    Button btnmasuk;
    SharedPreferences sharedPreferences;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ednama = (EditText)findViewById(R.id.ednama);
        edpass = (EditText)findViewById(R.id.edpass);
        btnmasuk = (Button)findViewById(R.id.btnmasuk);

        SharedPreferences.Editor editor;
        pref= getSharedPreferences("testap",MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("login","true");
        editor.commit();

        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ednama.getText().toString().equals("admin") && edpass.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Home.class);

                    String user = ednama.getText().toString();
                    sharedPreferences = getSharedPreferences("masuk", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user", user);
                    editor.commit();
                    editor.apply();
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_SHORT).show();


                }
            }
        });


    }
    @Override
    protected  void  onActivityResult(int requstCode,int resultCode,Intent data){
        sharedPreferences = sharedPreferences =getSharedPreferences("login",Context.MODE_PRIVATE);
        boolean stateValue =sharedPreferences.getBoolean("",false);
        if (requstCode ==  MAIN_ACTIVITY_REQUEST_CODE){
            if (!stateValue){
                finish();
            }else {
                updateLoginState(false);
                super.onActivityResult(requstCode,resultCode,data);
        }
        }else {
            super.onActivityResult(requstCode,resultCode,data);
        }
    }
    private void updateLoginState(boolean b){

    }
}
