package com.example.eventplannerapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

   
    private final String USERNAME = "sami";
    private final String PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                etUsername.setError("الرجاء إدخال اسم المستخدم");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                etPassword.setError("الرجاء إدخال كلمة المرور");
                return;
            }

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "اسم المستخدم أو كلمة المرور غير صحيحة", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
