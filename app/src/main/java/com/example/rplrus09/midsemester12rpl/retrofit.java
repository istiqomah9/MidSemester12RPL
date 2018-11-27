package com.example.rplrus09.midsemester12rpl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class retrofit {
    private  static Retrofit retrofit;
    private  static  final  String BASE_URL = "https://api.themoviedb.org/3/movie/";

    public  static  Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }

}
