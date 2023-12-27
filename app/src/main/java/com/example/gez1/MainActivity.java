package com.example.gez1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    CardView gezCard,begeniCard,oturumCard;
    FirebaseAuth auth;
    FirebaseUser user;

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

    }


    public void tanimla(){
        gezCard = findViewById(R.id.gezCard);
        begeniCard = findViewById(R.id.begeniCard);
        oturumCard = findViewById(R.id.oturumCard);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

    }


}
