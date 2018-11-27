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
import com.example.rplrus09.midsemester12rpl.database.MahasiswaHelper;
import com.example.rplrus09.midsemester12rpl.database.MahasiswaModel;

import java.util.ArrayList;

/**
 * Created by RPL RUS 09 on 11/23/2018.
 */

public class recyclerAdapterTab extends  RecyclerView.Adapter<recycleHolder>{
    Context context;
    private ArrayList<Result> ArrayList;


    public recyclerAdapterTab(Context context, ArrayList<Result> ArayList) {
        this.context = context;
        this.ArrayList = ArayList;

    }


    @NonNull
    @Override
    public recycleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutview = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail, parent, false);
        recycleHolder rc = new recycleHolder(layoutview);
        return rc;
    }

    @Override
    public void onBindViewHolder(@NonNull recycleHolder holder, final int position) {
        final Result model = ArrayList.get(position);
        Glide.with(context)
                .load(only_url.url+model.getPosterPath())
                .into(holder.gambar);
        holder.nama.setText(ArrayList.get(position).getTitle());
        holder.btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nama = ArrayList.get(position).getTitle();
                final String deskripsi = ArrayList.get(position).getOverview();
                final String gambar = only_url.url+ArrayList.get(position).getPosterPath();
                //final String id = String.valueOf(ArrayList.get(position).getId());
                Intent a = new Intent(context.getApplicationContext(), full.class);
                a.putExtra("nama", nama);
                a.putExtra("deskripsi", deskripsi);
                a.putExtra("gambar",gambar);
                //a.putExtra("id",id);
                //a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
                final int position1 = position;
                final String name = model.getTitle();
                ArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemChanged(position,ArrayList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return ArrayList.size();
    }
}
