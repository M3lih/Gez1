package com.example.gez1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class YerDetayActivity extends AppCompatActivity {

    CardView cardView;
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yer_detay);
        tanimla();

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

    }




}