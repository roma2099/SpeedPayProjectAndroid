package com.example.speedpayprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaReceberDinheiro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_enviar_dinheiro);
    }
    public void irTelaInicial (View View){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
    public void irTelaOpcaoReceber(View View){
        Intent intent = new Intent(this, TelaOpcaoReceber.class);
        startActivity(intent);
    }
}