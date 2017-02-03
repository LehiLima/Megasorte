package com.lehi.megasorte;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ParticipanteActivity extends AppCompatActivity {
    private DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participante);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Botão voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Anuncios
        AdView adView = (AdView) findViewById(R.id.adviewvParticipantes);
        AdRequest adRequest = new  AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

    public void salvarPart(View view)
    {
        mydb = new DBHelper(view.getContext());
        // vincula os layouts
        EditText email = (EditText) findViewById(R.id.email);
        EditText nome = (EditText) findViewById(R.id.nome);
        if (email.length() == 0 || nome.length() == 0){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alerta");
        alertDialog.setMessage("Todos os campos devem ser preenchidos!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        }else{
            if(mydb.insertParticipantes(email.getText().toString(), nome.getText().toString())){
                Toast.makeText(this,"Salvo com sucesso",Toast.LENGTH_SHORT).show();
                email.setText("");
                nome.setText("");
            }
        }

    }

}
