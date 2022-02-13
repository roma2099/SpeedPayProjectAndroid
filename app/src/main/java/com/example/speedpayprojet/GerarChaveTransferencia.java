package com.example.speedpayprojet;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class GerarChaveTransferencia extends AppCompatActivity {
    TextView txtViewChave;
    TextView txtViewValor;
    DatabaseReference database;
    DatabaseReference mdatabase;
    String chave;
    String valor;
    TextView tvValor;

    String userID;
    Long money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_chave_transferencia);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        iniciliarConponentes();
        chave=getIntent().getStringExtra("chavetrans");
        valor=getIntent().getStringExtra("valortrans");

        txtViewChave.setText(chave);///TODO Tirar o "+valor" apos teste
        tvValor.setText(valor);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userID="j48hvYWHMBS6kVDUIt8rSxPYeC82qq";
        if (user != null) {
            userID=user.getUid();
        } else {
            // No user is signed in
        }
        database = FirebaseDatabase.getInstance().getReference("/Users/"+userID+"/money");


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                money=(Long) snapshot.getValue();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        database = FirebaseDatabase.getInstance().getReference("/Transasao/"+chave);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if ((boolean)snapshot.child("done").getValue()){
                    Intent intent = new Intent(GerarChaveTransferencia.this, Sucesso.class);

                    //Toast.makeText(getApplicationContext(),"deu ",Toast.LENGTH_LONG).show();
                    //money= (Long) snapshot.child("User").child(userID).child("money").getValue();

                    Toast.makeText(getApplicationContext(),"deu "+money,Toast.LENGTH_LONG).show();

                    HashMap hashMap =new HashMap();
                    hashMap.put("money", money+Long.parseLong(valor));



                    mdatabase = FirebaseDatabase.getInstance().getReference("/Users/"+userID);
                    mdatabase.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            ////Adicionar novo Histoco
                            Historico historico = new Historico();
                            historico.saldo=""+(money);
                            historico.data="14/02/2022";
                            historico.tipoTransasao="Receber";
                            historico.valorTrans=""+valor;
                            addHistorico(historico);


                        }
                    });
                    startActivity(intent);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public void irTelaAnterior (View View){
        Intent intent = new Intent(this, TelaOpcaoReceber.class);
        String chave= getIntent().getStringExtra("chavetrans");
        String valor= getIntent().getStringExtra("valortrans");
        intent.putExtra("chavetrans",chave);
        intent.putExtra("valortrans",valor);
        startActivity(intent);
    }
    public void irTelaInicialx (View View){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }
    private void iniciliarConponentes(){
        txtViewChave=(TextView) findViewById(R.id.textView39);
        tvValor=(TextView) findViewById(R.id.idvalor);

    }
    public void addHistorico(Historico historico){
        database = FirebaseDatabase.getInstance().getReference("/Users/"+userID+"/Historico");
        chave =database.push().getKey();
        database.child(chave).setValue(historico).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {


            }
        });

    }
}