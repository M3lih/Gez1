package com.example.gez1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gez1.Models.MyModel;
import com.example.gez1.service.ApiService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OneriActivity extends AppCompatActivity {


    CardView cardsehir;
    ListView listView;
    TextView textView;
    String TAG = "OneriActivity";
    ArrayList<MyModel> dummyData = new ArrayList<>();


    static CustomListAdapter customListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneri);
        tanimla();
        getdata();
    }


    public void tanimla() {
        cardsehir = findViewById(R.id.cardsehir);
        textView = findViewById(R.id.txtYerIsim);
        listView = findViewById(R.id.listShowJSONDataOneri);

    }


    public void getdata() {

        try {

            new ApiService().getOneriData(new Callback<MyModel>() {
                @Override
                public void onResponse(Call<MyModel> call, Response<MyModel> response) {

                    Log.d(TAG, "onResponse: response..." + response);


                    //This will get result part from dummy JSON response
                    dummyData = response.body().getResults();
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



}