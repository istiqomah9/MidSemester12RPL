package com.example.rplrus09.midsemester12rpl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rplrus09.midsemester12rpl.database.MahasiswaHelper;
import com.example.rplrus09.midsemester12rpl.database.MahasiswaModel;

import java.util.ArrayList;

public class Favorite extends AppCompatActivity {
    private MahasiswaHelper mahasiswaHelper;
    RecyclerView recyclerView;
    private ArrayList<MahasiswaModel>models;
    TextView textdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        textdata = findViewById(R.id.textdata);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mahasiswaHelper = new MahasiswaHelper(getApplicationContext());
        models =mahasiswaHelper.getAllData();
        ModelAdapter adapter= new ModelAdapter(getApplicationContext(),models);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        Log.d("failed","onCreat:"+"sucses");


    }
@Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
