package com.example.gez1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SehirlerActivity extends AppCompatActivity {

    CardView istanbulCard,ankaraCard,izmirCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehirler);


        tanimla();
        istanbulTikla();
        ankaraTikla();
        izmirTikla();

    }

    public void istanbulTikla(){
        istanbulCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SehirlerActivity.this, IstanbulActivity.class);
                startActivity(intent);
            }
        });
    }



    public void ankaraTikla(){
        ankaraCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SehirlerActivity.this, AnkaraActivity.class);
                startActivity(intent);
            }
        });
    }


    public void izmirTikla(){
        izmirCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SehirlerActivity.this, IzmirActivity.class);
                startActivity(intent);
            }
        });
    }


    public void tanimla(){
        istanbulCard = findViewById(R.id.istanbulcard);
        ankaraCard = findViewById(R.id.ankaracard);
        izmirCard = findViewById(R.id.izmircard);
    }
}