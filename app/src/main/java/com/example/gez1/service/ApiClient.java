package com.example.gez1.service;

import android.content.Intent;

import com.example.gez1.Models.MyModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiClient {
    @GET("/yerler.php")
    Call<MyModel> getJSONData();

    @GET("/ankara.php")
    Call<MyModel> getAnkaraData();

    @GET("/izmir.php")
    Call<MyModel> getIzmirData();


    @GET("/begeni.php")
    Call<MyModel> getBegeniData(@Query("kullaniciID") int kullaniciID);




}