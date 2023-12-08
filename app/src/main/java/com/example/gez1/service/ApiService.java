package com.example.gez1.service;

import com.example.gez1.Models.MyModel;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiService {

    public void getClientList(Callback<MyModel> callback) {

        ApiClient service = ApiClientBuilder.getMGClient();

        Call<MyModel> result =  service.getJSONData();

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


}