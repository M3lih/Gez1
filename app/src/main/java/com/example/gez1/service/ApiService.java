package com.example.gez1.service;

import com.example.gez1.Models.MyModel;
import com.example.gez1.Models.Result;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiService {

    public void getClientList(Callback<MyModel> callback) {

        ApiClient service = ApiClientBuilder.getMGClient();

        Call<MyModel> result = service.getJSONData();

        result.enqueue(callback);

    }

    public void getAnkaraData(Callback<MyModel> callback) {
        ApiClient service = ApiClientBuilder.getAnkaraClient();
        Call<MyModel> result = service.getAnkaraData();
        result.enqueue(callback);
    }


    public void getIzmirData(Callback<MyModel> callback) {
        ApiClient service = ApiClientBuilder.getIzmirClient();
        Call<MyModel> result = service.getIzmirData();
        result.enqueue(callback);
    }

    public void getBegeniData(String kullaniciID, Callback<MyModel> callback) {
        ApiClient service = ApiClientBuilder.getBegeniClient(); // ApiClientBuilder, Retrofit servisinizi oluşturduğunuz bir sınıf olmalıdır
        Call<MyModel> result = service.getBegeniData(kullaniciID);
        result.enqueue(callback);
    }


    public void getKullaniciEkle(String kullaniciID,String yerID,String yerAciklama,String yerIsim,String yerKonum,String yerKategori,String yerResim,Callback<Result> callback) {
        ApiClient service = ApiClientBuilder.getKullaniciEkleClient(); // ApiClientBuilder, Retrofit servisinizi oluşturduğunuz bir sınıf olmalıdır
        Call<Result> result = service.getKullaniciEkle(kullaniciID,yerID,yerAciklama,yerIsim,yerKonum,yerKategori,yerResim);
        result.enqueue(callback);
    }

    public void getSil(String kullaniciID,String yerID,Callback<Result> callback) {
        ApiClient service = ApiClientBuilder.getSil(); // ApiClientBuilder, Retrofit servisinizi oluşturduğunuz bir sınıf olmalıdır
        Call<Result> result = service.getSil(kullaniciID,yerID);
        result.enqueue(callback);
    }


    public void getOneriData(Callback<MyModel> callback){
        ApiClient service = ApiClientBuilder.getOneriClient();
        Call<MyModel> result = service.getOneriData();
        result.enqueue(callback);
    }

    public void getTumyerlerData(int sehirID,String yerKategori, Callback<MyModel> callback){
        ApiClient service = ApiClientBuilder.getTumyerlerClient();
        Call<MyModel> result = service.getTumyerlerData(sehirID,yerKategori);
        result.enqueue(callback);
    }



}