package com.example.gez1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText girisEmail,girisPassword;
    private TextView kayitText,sifreResetText;
    private Button girisBtn;
    ProgressBar progressBar;

    String TAG = "login";



    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser != null && currentUser.isEmailVerified()){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        girisEmail = findViewById(R.id.login_email);
        girisPassword = findViewById(R.id.login_password);
        girisBtn = findViewById(R.id.login_btn);
        kayitText = findViewById(R.id.kayitoltext);
        sifreResetText = findViewById(R.id.sifreReset);
        progressBar = findViewById(R.id.progressBar);



        kayitText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


        sifreResetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!girisEmail.getText().toString().equals("")){
                    auth.sendPasswordResetEmail(girisEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Sifre sifirlama email gonderildi!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }   else {
                    Toast.makeText(getApplicationContext(), "Gecerli email giriniz!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });



        girisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email, password;
                email = String.valueOf(girisEmail.getText().toString());
                password = String.valueOf(girisPassword.getText().toString());

                Log.i(TAG, "onClick:"+email+ password);

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(LoginActivity.this, "Email Giriniz", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Sifre Giriniz", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }

                Task<AuthResult> authResultTask = auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                FirebaseUser user = auth.getCurrentUser();
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful() && user.isEmailVerified()){
                                    Toast.makeText(getApplicationContext(), "Basarili giris", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {

                                    Toast.makeText(LoginActivity.this, "Hatali Giris.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });

    }
}