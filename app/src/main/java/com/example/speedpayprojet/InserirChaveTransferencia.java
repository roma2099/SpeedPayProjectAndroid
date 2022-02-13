package com.example.speedpayprojet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InserirChaveTransferencia extends AppCompatActivity {
    ImageView btnConfirmar;
    EditText etChave;
    String chave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_chave_transferencia);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnConfirmar= (ImageView) findViewById(R.id.imageView109) ;
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etChave= findViewById(R.id.editTextTextPersonName3);

                chave = etChave.getText().toString();
                ///Toast.makeText(getApplicationContext(),chave,Toast.LENGTH_LONG).show();

                Intent intent= new Intent(InserirChaveTransferencia.this,ConfirmarAutenticasao.class);
                intent.putExtra("chavetrans",chave);
                startActivity(intent);

            }
        });
    }
    public void irTelaAnterior (View View){
        Intent intent = new Intent(this, TelaEnviarDinheiroSpeed.class);
        startActivity(intent);
    }
    public void irTelaAutenticasao (View View){
        Intent intent = new Intent(this,ConfirmarAutenticasao.class);
        intent.putExtra("chavetrans",chave);
        startActivity(intent);
    }
}