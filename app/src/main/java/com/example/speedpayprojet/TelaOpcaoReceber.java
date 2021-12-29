package com.example.speedpayprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class TelaOpcaoReceber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcao_receber);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void irTelaChaveTransf (View View){
        Intent intent = new Intent(this, GerarChaveTransferencia.class);
        startActivity(intent);
    }
    public void irTelaQR (View View){
        Intent intent = new Intent(this, GerarQRCodeTransferencia.class);
        startActivity(intent);
    }
    public void irTelaAnterior (View View){
        Intent intent = new Intent(this, TelaReceberDinheiro.class);
        startActivity(intent);
    }
}