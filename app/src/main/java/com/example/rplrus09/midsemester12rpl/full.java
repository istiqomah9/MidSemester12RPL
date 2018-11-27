package com.example.rplrus09.midsemester12rpl;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rplrus09.midsemester12rpl.database.MahasiswaHelper;
import com.example.rplrus09.midsemester12rpl.database.MahasiswaModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class full extends AppCompatActivity {
    ImageView photo;
    TextView user, tdeskripsi;
    String username;
    String deskripsi;
    String gambar;
    Button btntrailer;
    boolean flag = true;
    FloatingActionButton btnfab;
    MahasiswaHelper mahasiswaHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        photo = findViewById(R.id.photo);
        user = findViewById(R.id.user);
        tdeskripsi = findViewById(R.id.tdeskripsi);
        btntrailer = findViewById(R.id.btntrailer);
        btnfab = findViewById(R.id.btnfab);
        mahasiswaHelper = new MahasiswaHelper(getApplicationContext());
        Intent a = getIntent();
        Bundle bundle = a.getExtras();
//        new myfavasyntask().execute();
        username = bundle.getString("nama");
        deskripsi = bundle.getString("deskripsi");
        gambar = bundle.getString("gambar");
        user.setText(username);
        tdeskripsi.setText(deskripsi);
        Glide.with(full.this)
                .load(gambar)
                .into(photo);
        Log.e("TAG", "onCreate: " + gambar);
        btntrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webInten = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=LrLK67UL4L4"));
                startActivity(webInten);
            }
        });

        btnfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    MahasiswaModel mahasiswaModel = new MahasiswaModel(username, deskripsi, gambar);
                    mahasiswaHelper.insertTransaction(mahasiswaModel);
                    Toast.makeText(getApplicationContext(), "tersimpan", Toast.LENGTH_SHORT).show();
                    btnfab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_circle_black_24dp));
                    flag = false;

                } else {
                    btnfab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_check_black_24dp));
                    flag = true;
                }
            }
        });
    }
//    @SuppressLint("StaticFieldLeak")
//    public class myfavasyntask extends AsyncTask<Void, Void, Boolean> {
//
//
//        @Override
//        protected void onPreExecute() {
////            pgloading.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected Boolean doInBackground(Void... params) {
//            Boolean suksesLoad = true;
//            return suksesLoad;
//
//        }
//
//        @Override
//        protected void onPostExecute(Boolean suksesLoad) {
//           // btnfab.setEnabled(false);
//            super.onPostExecute(suksesLoad);
//        }
//    }
}

