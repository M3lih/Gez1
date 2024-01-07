package com.example.gez1.service;

import android.content.Intent;

import com.example.gez1.Models.MyModel;
import com.example.gez1.Models.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    Call<MyModel> getBegeniData(@Query("kullaniciID") String kullaniciID);



    @FormUrlEncoded
    @POST("/ekle.php")
    Call<Result> getKullaniciEkle(@Field("kullaniciID") String kullaniciID, @Field("yerID") String yerID,@Field("yerAciklama") String yerAciklama,@Field("yerIsim") String yerIsim,@Field("yerKonum") String yerKonum,@Field("yerKategori") String yerKategori,@Field("yerResim") String yerResim);


    @FormUrlEncoded
    @POST("/sil.php")
    Call<Result> getSil(@Field("kullaniciID") String kullaniciID, @Field("yerID") String yerID);

    @GET("/oneri.php")
    Call<MyModel>getOneriData();


}