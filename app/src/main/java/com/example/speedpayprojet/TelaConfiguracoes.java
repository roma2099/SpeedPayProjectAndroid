package com.example.speedpayprojet;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TelaConfiguracoes extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;

    private ImageView logout;
    private TextView nametxt, emailtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_configuracoes);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        nametxt = (TextView) findViewById(R.id.nametxt);
        emailtxt = (TextView) findViewById(R.id.emailtxt);
        logout = (ImageView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirDialog();
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);

                if (userprofile != null) {
                    String fullname = userprofile.fullname;
                    nametxt.setText(fullname);
                    String email = userprofile.email;
                    emailtxt.setText(email);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void irTelaInicial (View View){
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }

    public void irTelaForgotPassword (View View){
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

    public void abrirDialog (){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Sair da Conta");
        dialog.setMessage("Tem a certeza que deseja sair da conta?");

        dialog.setCancelable(false);

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Esperamos ve-lo novamente em breve",Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(TelaConfiguracoes.this, TelaLoginRegisto.class));
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        dialog.create();
        dialog.show();

    }

}