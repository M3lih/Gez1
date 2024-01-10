package com.example.gez1;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
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

import com.example.gez1.Fragments.EgitimFragment;
import com.example.gez1.Fragments.GeziFragment;
import com.example.gez1.Models.MyModel;
import com.example.gez1.service.ApiService;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class IstanbulActivity extends AppCompatActivity {

    CardView cardsehir;
    ListView listView;
    TextView textView;
    String TAG = "IstanbulActivity";
    ArrayList<MyModel> dummyData = new ArrayList<>();
    static CustomListAdapter customListAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    private int sehirID = 34;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istanbul);

        //Make a server call and get data
        tanimla();
        getdata();
        istyertikla();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Connect the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);





    }


    public void tanimla() {
        cardsehir = findViewById(R.id.cardsehir);
        textView = findViewById(R.id.txtYerIsim);
        //listView = findViewById(R.id.listShowJSONData);
        viewPager = findViewById(R.id.viewPageristanbul);
        tabLayout = findViewById(R.id.istanbulTab);

    }

    public void getdata() {
        try {

            new ApiService().getClientList(new Callback<MyModel>() {
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




    public void istyertikla() {

    }

    public int getMyData(){
        return sehirID;
    }



    



}








