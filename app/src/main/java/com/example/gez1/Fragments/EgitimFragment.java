package com.example.gez1.Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gez1.AnkaraActivity;
import com.example.gez1.CustomListAdapter;
import com.example.gez1.IstanbulActivity;
import com.example.gez1.IzmirActivity;
import com.example.gez1.Models.MyModel;
import com.example.gez1.R;
import com.example.gez1.service.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EgitimFragment extends Fragment {

    ListView listView;
    ArrayList<MyModel> dummyData = new ArrayList<>();
    static CustomListAdapter customListAdapter;
    String TAG = "EgitimFragment";




    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_egitim,
                container, false);

        listView = view.findViewById(R.id.listViewEgitim);


        getdata();

        return view;
    }



    public void getdata() {

        try {

            int sehirID = -1; // Default value or any meaningful default for your case

            Activity hostingActivity = getActivity();

            if (hostingActivity instanceof IstanbulActivity) {
                // If the hosting activity is IstanbulActivity
                IstanbulActivity istanbulActivity = (IstanbulActivity) hostingActivity;
                sehirID = istanbulActivity.getMyData();
                // Do something with sehirID from IstanbulActivity
            } else if (hostingActivity instanceof AnkaraActivity) {
                // If the hosting activity is AnkaraActivity
                AnkaraActivity ankaraActivity = (AnkaraActivity) hostingActivity;
                sehirID = ankaraActivity.getMyData();

                // Do something with sehirID from AnkaraActivity
            } else if (hostingActivity instanceof IzmirActivity) {
                // If the hosting activity is AnkaraActivity
                IzmirActivity izmirActivity = (IzmirActivity) hostingActivity;
                sehirID = izmirActivity.getMyData();

                // Do something with sehirID from AnkaraActivity
            } else {
//                IzmirActivity izmirActivity = (IzmirActivity) hostingActivity;
//                sehirID = izmirActivity.getMyData();
            }



            Log.i(TAG, "bum"+sehirID);
            new ApiService().getTumyerlerData(sehirID,"'Egitim'",new Callback<MyModel>() {
                @Override
                public void onResponse(Call<MyModel> call, Response<MyModel> response) {

                    Log.d(TAG, "onResponse: response..." + response.body());


                    //This will get result part from dummy JSON response
                    dummyData = response.body().getResults();

                    Log.i(TAG, "sonuc"+dummyData);



                    createListView();
                }

                @Override
                public void onFailure(Call<MyModel> call, Throwable t) {

                    Log.d(TAG, "onFailure: response...");
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }





    public void createListView() {
        //Send JSON object list to custom BaseAdapter
        customListAdapter = new CustomListAdapter(getActivity().getApplication(), dummyData);
        listView.setAdapter(customListAdapter);

    }

}