package com.example.speedpayprojet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void irTelaCarteira (View View){
        Intent intent = new Intent(this, TelaCarteira.class);
        startActivity(intent);
    }
    public void irTelaHistorico (View View){
        Intent intent = new Intent(this, TelaHistorico.class);
        startActivity(intent);
    }

    public void irTelaReceberDinheiro (View View){
        Intent intent = new Intent(this, TelaReceberDinheiro.class);
        startActivity(intent);
    }

    public void irTelaEnviarDinheiro(View View){
        Intent intent = new Intent(this, TelaEnviarDinheiroSpeed.class);
        startActivity(intent);
    }

    public void irTelaConfiguracoes(View View){
        Intent intent = new Intent(this, TelaConfiguracoes.class);
        startActivity(intent);
    }

}