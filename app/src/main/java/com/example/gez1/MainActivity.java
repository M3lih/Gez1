package com.example.gez1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    CardView gezCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        tiklama();

    }

    public void tiklama(){
        gezCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SehirlerActivity.class);
                startActivity(intent);
            }
        });
    }


    public void tanimla(){
        gezCard = findViewById(R.id.gezCard);
    }


}
