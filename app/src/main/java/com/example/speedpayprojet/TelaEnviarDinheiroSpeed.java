package com.example.speedpayprojet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TelaEnviarDinheiroSpeed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_enviar_dinheiro_speed);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void irTelaInicial (View View){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
    public void irTelaInserirChaveTransferencia (View View){
        Intent intent = new Intent(this, InserirChaveTransferencia.class);
        startActivity(intent);
    }
    public void irTelaQRCodeScan (View View){
        Intent intent = new Intent(this, Scan_QRCode.class);
        startActivity(intent);
    }
}