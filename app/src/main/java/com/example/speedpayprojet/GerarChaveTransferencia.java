package com.example.speedpayprojet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GerarChaveTransferencia extends AppCompatActivity {
    TextView txtViewChave;
    TextView txtViewValor;
    private String chave;
    private String valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_chave_transferencia);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        iniciliarConponentes();
        chave=getIntent().getStringExtra("chavetrans");
        valor=getIntent().getStringExtra("valortrans");

        txtViewChave.setText(chave);///TODO Tirar o "+valor" apos teste


    }
    public void irTelaAnterior (View View){

        Intent intent = new Intent(this, TelaOpcaoReceber.class);
        intent.putExtra("valortrans",String.valueOf(valor));
        intent.putExtra("chavetrans",String.valueOf(chave));
        startActivity(intent);
    }
    public void irTelaInicialx (View View){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
    private void iniciliarConponentes(){
        txtViewChave=(TextView) findViewById(R.id.textView39);

    }
}