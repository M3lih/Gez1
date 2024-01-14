package com.example.gez1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfilActivity extends AppCompatActivity {


    EditText editTexthakkinda;
    Button duzenleBtn,guncelleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        tanimla();
    }














    public void tanimla(){
        editTexthakkinda = findViewById(R.id.hakkinda);
        duzenleBtn = findViewById(R.id.duzenleBtn);
        guncelleBtn = findViewById(R.id.guncelleBtn);
        duzenleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTexthakkinda.setEnabled(true);
                editTexthakkinda.setFocusable(true);
                editTexthakkinda.setFocusableInTouchMode(true);
                editTexthakkinda.requestFocus();
            }
        });

        guncelleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yeni = String.valueOf(editTexthakkinda.getText());
                Log.i("TAG", "profil:"+yeni);
            }

        });


    }
}