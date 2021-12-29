package com.example.speedpayprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class InserirChaveTransferencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_chave_transferencia);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void irTelaAnterior (View View){
        Intent intent = new Intent(this, TelaEnviarDinheiroSpeed.class);
        startActivity(intent);
    }
    public void irTelaSucesso (View View){
        Intent intent = new Intent(this, Sucesso.class);
        startActivity(intent);
    }
}