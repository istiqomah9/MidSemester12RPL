package com.example.rplrus09.midsemester12rpl;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RPL RUS 09 on 11/19/2018.
 */

public interface Json_api {
    @GET("upcoming?api_key=05d24d1094bc376832434c74ca08824f")
    Call<json_respond>getJsonNowPlaying();
}
