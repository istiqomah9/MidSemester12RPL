
package com.example.rplrus09.midsemester12rpl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Home extends AppCompatActivity {


    public ArrayList<lengkap> ratarata = new ArrayList<lengkap>();
    RecyclerView recycler_View;
    lengkap lengkap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Now Playing"));
        tabLayout.addTab(tabLayout.newTab().setText("Up Coming"));
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final pageAdapter adapter = new pageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.keluar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_keluar:
                moveTaskToBack(true);
                SharedPreferences sharedPreferences = getSharedPreferences("masuk", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(Home.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            case R.id.item_favorite:
                Intent i = new Intent(this,Favorite.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        recycler_View = (RecyclerView) findViewById(R.id.recycler_view);
//        new ambildata().execute();
//
//        recycler_View.setLayoutManager(new LinearLayoutManager(Home.this));
//        RecycleViewAdapter Adapter = new RecycleViewAdapter(Home.this, ratarata);
//        recycler_View.setAdapter(Adapter);
//    }
//
//    @SuppressLint("StaticFieldLeak")
//    public class ambildata extends AsyncTask<Void, Void, JSONObject> {
//
//
//        @Override
//        protected void onPreExecute() {
//
//        }
//
//        @Override
//        protected JSONObject doInBackground(Void... params) {
//            JSONObject jsonObject;
//            try {
//                String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=05d24d1094bc376832434c74ca08824f&language=en-US";
//                DefaultHttpClient httpClient = new DefaultHttpClient();
//                HttpGet httpGet = new HttpGet(url);
//                HttpResponse httpResponse = httpClient.execute(httpGet);
//                HttpEntity httpEntity = httpResponse.getEntity();
//                InputStream inputStream = httpEntity.getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(
//                        inputStream, "iso-8859-1"
//                ), 8);
//                StringBuilder stringBuilder = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    stringBuilder.append(line).append("\n");
//                }
//                inputStream.close();
//                String json = stringBuilder.toString();
//                jsonObject = new JSONObject(json);
//            } catch (Exception e) {
//                jsonObject = null;
//            }
//            return jsonObject;
//        }
//
//        @Override
//        protected void onPostExecute(JSONObject jsonObject) {
//            Log.d("Hasiljson", "onPostExecute:" + jsonObject.toString());
//            if (jsonObject != null) {
//                try {
//                    ratarata = new ArrayList<>();
//                    JSONArray aktualData = jsonObject.getJSONArray("results");
//                    for (int x = 0; x < aktualData.length(); x++) {
//                        lengkap = new lengkap();
//                        lengkap.setNama(aktualData.getJSONObject(x).getString("title"));
//                        lengkap.setGambar(aktualData.getJSONObject(x).getString("poster_path"));
//                        lengkap.setDeskripsi(aktualData.getJSONObject(x).getString("overview"));
//                        ratarata.add(lengkap);
//                    }
//                    recycler_View.setHasFixedSize(true);
//                    RecycleViewAdapter adapter = new RecycleViewAdapter(recycler_View.getContext(), ratarata);
//                    recycler_View.setLayoutManager(new LinearLayoutManager(recycler_View.getContext(), LinearLayoutManager.VERTICAL, false));
//                    recycler_View.setAdapter(adapter);
//                } catch (Exception ignored) {
//                    Log.d("Hasiljson", "onPostExecute: " + ignored.toString());
//                }
//            } else {
//            }
//            super.onPostExecute(jsonObject);
//        }
//    }
}