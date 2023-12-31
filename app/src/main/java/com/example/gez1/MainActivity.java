package com.example.gez1;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    CardView gezCard,begeniCard,oturumCard,cikisCard;
    FirebaseAuth auth;
    FirebaseUser user;
    String TAG = "main";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        tiklama();

        if(user == null){
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void tiklama(){
        gezCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SehirlerActivity.class);
                startActivity(intent);
            }
        });

        begeniCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BegendiklerimActivity.class);
                startActivity(intent);
            }
        });

        oturumCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        cikisCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showExitDialog();

            }
        });

    }


    public void tanimla(){
        gezCard = findViewById(R.id.gezCard);
        begeniCard = findViewById(R.id.begeniCard);
        oturumCard = findViewById(R.id.oturumCard);
        cikisCard = findViewById(R.id.cikisCard);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

    }


    public void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Çıkış Yap");
        builder.setMessage("Çıkış yapmak istediğinize emin misiniz?");

        // Olumlu buton (Evet) işlemi
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kullanıcı evet dediyse uygulamadan çıkış yap
                finish();
            }
        });

        // Olumsuz buton (Hayır) işlemi
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kullanıcı hayır dediyse, diyalog penceresini kapat
                dialog.dismiss();
            }
        });

        // Diyalog penceresini göster
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}
