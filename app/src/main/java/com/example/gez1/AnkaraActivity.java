package com.example.gez1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.gez1.Models.MyModel;
import com.example.gez1.service.ApiService;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AnkaraActivity extends AppCompatActivity {

    CardView cardsehir;
    ListView listView;
    TextView textView;
    String TAG = "AnkaraActivity";
    ArrayList<MyModel> dummyData = new ArrayList<>();
    static CustomListAdapter customListAdapter;

    ViewPager viewPager;
    TabLayout tabLayout;
    private int sehirID = 06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ankara);

        //Make a server call and get data
        tanimla();
        getdata();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Connect the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);

    }


    public void tanimla() {
        //listView = findViewById(R.id.list);
        cardsehir = findViewById(R.id.cardsehir);
        textView = findViewById(R.id.txtYerIsim);
        tabLayout = findViewById(R.id.ankaraTab);
        viewPager = findViewById(R.id.viewPagerankara);
    }

    public void getdata() {
        try {

            new ApiService().getAnkaraData(new Callback<MyModel>() {
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
        //Send JSON object list to custom BaseAdapter
        customListAdapter = new CustomListAdapter(getApplicationContext(), dummyData);
        //listView.setAdapter(customListAdapter);


    }

    public int getMyData(){
        return sehirID;
    }


}







