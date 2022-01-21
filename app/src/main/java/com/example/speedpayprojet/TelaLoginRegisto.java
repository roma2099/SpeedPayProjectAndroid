package com.example.speedpayprojet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLoginRegisto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_registo);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void irTelaLoginRegisto (View View){
        Intent intent = new Intent(this, TelaRegistrar.class);
        startActivity(intent);
    }

    public void irTelaLogin (View View){
        Intent intent = new Intent(this, TelaLogin.class);
        startActivity(intent);
    }
}