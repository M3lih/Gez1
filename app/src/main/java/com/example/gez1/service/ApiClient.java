package com.example.gez1.service;

import com.example.gez1.Models.MyModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("/yerler.php")
    Call<MyModel> getJSONData();

    @GET("/ankara.php")
    Call<MyModel> getAnkaraData();

    @GET("/izmir.php")
    Call<MyModel> getIzmirData();

}