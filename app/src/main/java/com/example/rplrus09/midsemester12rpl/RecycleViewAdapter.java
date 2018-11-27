package com.example.rplrus09.midsemester12rpl;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<recycleHolder> {
    private List<lengkap> ratarata;
    Context context;
//    String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";

    public RecycleViewAdapter(Context context, ArrayList<lengkap> ratarata) {
        this.context = context;
        this.ratarata = ratarata;
    }

    @Override
    public recycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutview = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail, parent, false);
        recycleHolder rc = new recycleHolder(layoutview);
        return rc;
    }

    @Override
    public void onBindViewHolder(final recycleHolder holder, final int position) {
        final lengkap lengkap = ratarata.get(position);

        Glide.with(context)
                .load(lengkap.getGambar())
                .into(holder.gambar);
        holder.nama.setText(ratarata.get(position).getNama());
        holder.btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nama = ratarata.get(position).getNama();
                final String deskripsi = ratarata.get(position).getDeskripsi();
                final String gambar =  lengkap.getGambar();
                final String trailer = lengkap.getTrailer();
                Intent a = new Intent(context.getApplicationContext(), full.class);
                a.putExtra("nama", nama);
                a.putExtra("deskripsi", deskripsi);
                a.putExtra("gambar", gambar);
                a.putExtra("trailer",trailer);
                context.startActivity(a);

            }
        });
        holder.btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.ratarata.size();
    }
}
