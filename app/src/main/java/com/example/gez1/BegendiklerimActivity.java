package com.example.gez1;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gez1.Models.MyModel;
import com.example.gez1.Models.Result;
import com.example.gez1.service.ApiClient;
import com.example.gez1.service.ApiClientBuilder;
import com.example.gez1.service.ApiService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BegendiklerimActivity extends AppCompatActivity {

    CardView cardsehir;
    ListView listView;
    TextView textView;
    String TAG = "BegendiklerimActivity";
    ArrayList<MyModel> dummyData = new ArrayList<>();
    ArrayList<MyModel> begeniList = new ArrayList<>();
    ArrayList kullanici = new ArrayList<>();
    int kullaniciID = 2;
    FirebaseUser user;
    FirebaseAuth auth;


    static CustomListAdapter customListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begendiklerim);

        tanimla();
        getdata();


    }


    public void tanimla() {
        cardsehir = findViewById(R.id.cardsehir);
        textView = findViewById(R.id.txtYerIsim);
        listView = findViewById(R.id.listShowJSONDataBegeni);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

    }


    public void getdata() {

       try {
        String userID = user.getUid();
        Log.i(TAG, "onCreate:userıd:"+userID);
        new ApiService().getBegeniData("'"+userID+"'",new Callback<MyModel>() {
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

        customListAdapter = new CustomListAdapter(getApplicationContext(), dummyData);
        listView.setAdapter(customListAdapter);
        customListAdapter.notifyDataSetChanged();
        listView.setAdapter(customListAdapter);

    }









//    String userID = user.getUid();
//    Call<MyModel> x = ApiClientBuilder.getBegeniClient().getBegeniData(userID);
//        x.enqueue(new Callback<MyModel>() {
//        @Override
//        public void onResponse(Call<MyModel> call, Response<MyModel> response) {
//            Log.d(TAG, "onResponse: response..." + response.body());
//
//            //This will get result part from dummy JSON response
//            dummyData = response.body().getResults();
//
//            Log.i(TAG, "sonuc"+dummyData);
//
//            createListView();
//
//        }
//
//        @Override
//        public void onFailure(Call<MyModel> call, Throwable t) {
//            Log.d(TAG, "onFailure: response...");
//
//        }
//    });




}
