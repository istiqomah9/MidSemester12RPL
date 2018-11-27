package com.example.rplrus09.midsemester12rpl;


public class lengkap {
    private String nama;
    private String gambar;
    private String deskripsi;
    private String trailer;
    private  String tanggal;

    public lengkap(){
        this.nama = nama;
        this.setGambar(getGambar());
        this.deskripsi=deskripsi;
        this.setTrailer(getTrailer());
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public void setGambar(int pho) {
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
