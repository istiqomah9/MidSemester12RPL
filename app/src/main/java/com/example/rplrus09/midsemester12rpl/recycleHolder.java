package com.example.rplrus09.midsemester12rpl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class recycleHolder extends RecyclerView.ViewHolder {
    public TextView nama;
    public ImageView gambar;
    public Button btnmasuk;
    public Button btnshare;
    public Button btndelete;

    public recycleHolder(View itemView) {
        super(itemView);
        nama = (TextView)itemView.findViewById(R.id.nama);
        gambar = (ImageView)itemView. findViewById(R.id.gambar);
        btnmasuk = (Button) itemView.findViewById(R.id.btnmasuk);
        btnshare = (Button) itemView.findViewById(R.id.btnshare);
        btndelete = (Button) itemView.findViewById(R.id.btndelete);
    }

}
