package com.example.demoapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface api {

    @GET("/data/2.5/onecall?lat=31.4958965&lon=74.3357794&appid=ad4b6b67d005acc92c137dafae218c85")
    Call<ResponseBody> getData();
}
