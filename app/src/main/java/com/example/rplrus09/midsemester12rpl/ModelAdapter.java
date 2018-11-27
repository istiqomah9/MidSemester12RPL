package com.example.rplrus09.midsemester12rpl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.rplrus09.midsemester12rpl.database.DatabaseContract;
import com.example.rplrus09.midsemester12rpl.database.DatabaseHelper;
import com.example.rplrus09.midsemester12rpl.database.MahasiswaHelper;
import com.example.rplrus09.midsemester12rpl.database.MahasiswaModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RPL RUS 09 on 10/29/2018.
 */

public class ModelAdapter extends RecyclerView.Adapter<recycleHolder> {
    Context context;
    private ArrayList<MahasiswaModel> mahasiswaArrayList;
    MahasiswaHelper mahasiswaHelper;

    public ModelAdapter(Context context, ArrayList<MahasiswaModel> mahasiswaModelArrayList) {
        this.context = context;
        this.mahasiswaArrayList = mahasiswaModelArrayList;
        mahasiswaHelper = new MahasiswaHelper(context);
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
        final MahasiswaModel model = mahasiswaArrayList.get(position);
        Glide.with(context)
                .load(model.getNim())
                .into(holder.gambar);
        Log.d("gambar", "onBindViewHolder: "+mahasiswaArrayList.get(position).getNim());
        holder.nama.setText(mahasiswaArrayList.get(position).getName());
        holder.btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nama = mahasiswaArrayList.get(position).getName();
                final String deskripsi = mahasiswaArrayList.get(position).getUrl();
                final String gambar = mahasiswaArrayList.get(position).getNim();
                final String id = String.valueOf(mahasiswaArrayList.get(position).getId());
                Intent a = new Intent(context.getApplicationContext(), full.class);
                a.putExtra("nama", nama);
                a.putExtra("deskripsi", deskripsi);
                a.putExtra("gambar", gambar);
                a.putExtra("id",id);
                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
                final String name = model.getId();
                mahasiswaHelper.delete(name);
                mahasiswaArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemChanged(position,mahasiswaArrayList.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mahasiswaArrayList.size();
    }
}
