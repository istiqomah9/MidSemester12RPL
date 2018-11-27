package com.example.rplrus09.midsemester12rpl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rplrus09.midsemester12rpl.database.MahasiswaHelper;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RPL RUS 09 on 11/23/2018.
 */

public class TwoFragment  extends Fragment {
    public ArrayList<Result> idolArrayList;
    lengkap lengkap;
    RecyclerView recyclerView;
    MahasiswaHelper mahasiswaHelper;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.Rview_up);
        mahasiswaHelper = new MahasiswaHelper(view.getContext());
       load_data_upcoming();
        return view;
    }
    private void load_data_upcoming() {
        Json_api service = retrofit.getRetrofitInstance().create(Json_api.class);
        Call<json_respond> call = service.getJsonNowPlaying();
        call.enqueue(new Callback<json_respond>() {
            @Override
            public void onResponse(Call<json_respond> call, Response<json_respond> response) {
                json_respond jsonRespond = response.body();
                idolArrayList = new ArrayList<>(Arrays.asList(jsonRespond.getResults()));
                Log.d("responku", "onResponse: " + jsonRespond.getResults());
                recyclerAdapterTab adapter = new recyclerAdapterTab(view.getContext(), idolArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<json_respond> call, Throwable t) {
                Log.d("responku", "onFailure: gagal");

            }

        });
    }



}
