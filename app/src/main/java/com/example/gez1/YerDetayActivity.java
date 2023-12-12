package com.example.gez1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gez1.Fragments.FragmentAciklama;
import com.example.gez1.Fragments.FragmentKonum;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class YerDetayActivity extends AppCompatActivity {

    CardView cardView;
    TextView textView,txt;
    ImageView imageView;

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyPagerAdapter myPagerAdapter;
    ToggleButton begenbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yer_detay);
        tanimla();
        tabsecim();

        Intent intent = getIntent();
        String yerIsim = intent.getStringExtra("yerIsim");
        String yerID = intent.getStringExtra("yerID");
        String yerAciklama = intent.getStringExtra("yerAciklama");
        String yerKonum = intent.getStringExtra("yerKonum");
        String yerKategori = intent.getStringExtra("yerKategori");
        String yerResim = intent.getStringExtra("yerResim");


        textView.setText(yerIsim);
        Picasso.get().load(yerResim).into(imageView);


    }


    public void tanimla(){
        cardView = findViewById(R.id.detaycard);
        textView = findViewById(R.id.detayisim);
        imageView = findViewById(R.id.detayimg);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(this);
        viewPager2.setAdapter(myPagerAdapter);
        begenbtn = findViewById(R.id.begenibtn);



    }

    public void tabsecim(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });


    }


    public void onCustomToggleClick(View view) {
        Intent intent = getIntent();
        String yerIsim = intent.getStringExtra("yerIsim");
        String yerID = intent.getStringExtra("yerID");
        String yerAciklama = intent.getStringExtra("yerAciklama");
        String yerKonum = intent.getStringExtra("yerKonum");
        String yerKategori = intent.getStringExtra("yerKategori");
        String yerResim = intent.getStringExtra("yerResim");
            if (begenbtn.isChecked()){


                Toast.makeText(this, "Beğenildi"+yerID, Toast.LENGTH_SHORT).show();

            }else
                Toast.makeText(this, "Beğenilerden Çıkarıldı!"+yerID, Toast.LENGTH_SHORT).show();
    }




}