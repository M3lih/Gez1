package com.example.gez1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    CardView gezCard,begeniCard,oturumCard,cikisCard,oneriCard,profilCard;
    FirebaseAuth auth;
    FirebaseUser user;
    String TAG = "main";
    GoogleSignInClient mGoogleSignInClient;


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

        if (mGoogleSignInClient == null) {
            // Eğer mGoogleSignInClient null ise, tekrar oluşturulmalı
            // Bu kısmı LoginActivity içinden alabilirsiniz
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken("802516051822-fr6esl33sqdi0euv4vvrsmhg5kl3romn.apps.googleusercontent.com")
                    .requestEmail()
                    .build();

            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
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
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
//                startActivity(intent);
//                finish();
                FirebaseAuth.getInstance().signOut();
                mGoogleSignInClient.signOut().addOnCompleteListener(
                        new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    // İsteğe bağlı olarak başka bir aktiviteye yönlendirme yapabilirsiniz.
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                    finish(); // Eğer bu aktiviteyi kapatmak istiyorsanız
                                } else {
                                    // İstediğiniz şekilde hata durumunu ele alabilirsiniz.
                                    Toast.makeText(getApplicationContext(), "Google ile oturum kapatılamadı", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });



            }
        });

        oneriCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OneriActivity.class);
                startActivity(intent);
            }
        });

        cikisCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showExitDialog();

            }
        });

        profilCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(intent);
            }
        });

    }


    public void tanimla(){
        gezCard = findViewById(R.id.gezCard);
        begeniCard = findViewById(R.id.begeniCard);
        oturumCard = findViewById(R.id.oturumCard);
        cikisCard = findViewById(R.id.cikisCard);
        oneriCard = findViewById(R.id.oneriCard);
        profilCard = findViewById(R.id.profilCard);

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
