package com.example.speedpayprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class GerarQRCodeTransferencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_qrcode_transferencia);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void irTelaAnterior (View View){
        Intent intent = new Intent(this, TelaOpcaoReceber.class);
        startActivity(intent);
    }

    public void irTelaInicialx (View View){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
}