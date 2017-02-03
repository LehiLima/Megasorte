package com.lehi.megasorte;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class ConferirJogoManualActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferir_jogo_manual);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rangePermitido(getApplicationContext());

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
        AdView adView = (AdView) findViewById(R.id.adviewconferirmanual);
        AdRequest adRequest = new  AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void btverificar(View view){

        EditText b1 = (EditText) findViewById(R.id.mcfb1);
        EditText b2 = (EditText) findViewById(R.id.mcfb2);
        EditText b3 = (EditText) findViewById(R.id.mcfb3);
        EditText b4 = (EditText) findViewById(R.id.mcfb4);
        EditText b5 = (EditText) findViewById(R.id.mcfb5);
        EditText b6 = (EditText) findViewById(R.id.mcfb6);

        if (b1.length() == 0 || b2.length() == 0 || b3.length() == 0 || b4.length() == 0 || b5
                .length() == 0 || b6.length() == 0){
            AlertDialog alertDialog = new AlertDialog.Builder(ConferirJogoManualActivity.this).create();
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
            conferirJogo();
        }


    }

    public void conferirJogo(){


        int sena = 0,quina = 0,quadra = 0,numacertos;

        EditText b1 = (EditText) findViewById(R.id.mcfb1);
        EditText b2 = (EditText) findViewById(R.id.mcfb2);
        EditText b3 = (EditText) findViewById(R.id.mcfb3);
        EditText b4 = (EditText) findViewById(R.id.mcfb4);
        EditText b5 = (EditText) findViewById(R.id.mcfb5);
        EditText b6 = (EditText) findViewById(R.id.mcfb6);



        // inicia o db para retornar todos os jogos na base
        DBHelper mydb = new DBHelper(getApplicationContext());
        final ArrayList<Jogo> jogos = new ArrayList<Jogo>();

        jogos.addAll(mydb.getAllJogos());

        //Link com a tela para buscar os valores


        TextView resultado_sena = (TextView) findViewById(R.id.msenanumero);
        TextView resultado_quina = (TextView) findViewById(R.id.mquinanumero);
        TextView resultado_quadra = (TextView) findViewById(R.id.mquadranumero);



        int b1int = Integer.parseInt(b1.getText().toString());
        int b2int = Integer.parseInt(b2.getText().toString());
        int b3int = Integer.parseInt(b3.getText().toString());
        int b4int = Integer.parseInt(b4.getText().toString());
        int b5int = Integer.parseInt(b5.getText().toString());
        int b6int = Integer.parseInt(b6.getText().toString());

        int [] jogo = {b1int,b2int,b3int,b4int,b5int,b6int};

        // Verifica todos os jogos da base de dados
        for(int count=0;count<jogos.size();count++){
            int bdbola1 = Integer.parseInt(jogos.get(count).getb1());
            int bdbola2 = Integer.parseInt(jogos.get(count).getb2());
            int bdbola3 = Integer.parseInt(jogos.get(count).getb3());
            int bdbola4 = Integer.parseInt(jogos.get(count).getb4());
            int bdbola5 = Integer.parseInt(jogos.get(count).getb5());
            int bdbola6 = Integer.parseInt(jogos.get(count).getb6());
            int bdbola7 = 0;
            int bdbola8 = 0;
            int bdbola9 = 0;
            int bdbola10 = 0;
            int bdbola11 = 0;
            int bdbola12 = 0;
            int bdbola13 = 0;
            int bdbola14 = 0;
            int bdbola15 = 0;
            if (jogos.get(count).getNumJogosdb() == 7) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
            }else   if (jogos.get(count).getNumJogosdb() == 8) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
            }else   if (jogos.get(count).getNumJogosdb() == 9) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
                bdbola9 = Integer.parseInt(jogos.get(count).getb9());
            }else   if (jogos.get(count).getNumJogosdb() == 10) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
                bdbola9 = Integer.parseInt(jogos.get(count).getb9());
                bdbola10 = Integer.parseInt(jogos.get(count).getb10());
            }else   if (jogos.get(count).getNumJogosdb() == 11) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
                bdbola9 = Integer.parseInt(jogos.get(count).getb9());
                bdbola10 = Integer.parseInt(jogos.get(count).getb10());
                bdbola11 = Integer.parseInt(jogos.get(count).getb11());
            }else   if (jogos.get(count).getNumJogosdb() == 12) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
                bdbola9 = Integer.parseInt(jogos.get(count).getb9());
                bdbola10 = Integer.parseInt(jogos.get(count).getb10());
                bdbola11 = Integer.parseInt(jogos.get(count).getb11());
                bdbola12 = Integer.parseInt(jogos.get(count).getb12());
            }else   if (jogos.get(count).getNumJogosdb() == 13) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
                bdbola9 = Integer.parseInt(jogos.get(count).getb9());
                bdbola10 = Integer.parseInt(jogos.get(count).getb10());
                bdbola11 = Integer.parseInt(jogos.get(count).getb11());
                bdbola12 = Integer.parseInt(jogos.get(count).getb12());
                bdbola13 = Integer.parseInt(jogos.get(count).getb13());
            }else   if (jogos.get(count).getNumJogosdb() == 14) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
                bdbola9 = Integer.parseInt(jogos.get(count).getb9());
                bdbola10 = Integer.parseInt(jogos.get(count).getb10());
                bdbola11 = Integer.parseInt(jogos.get(count).getb11());
                bdbola12 = Integer.parseInt(jogos.get(count).getb12());
                bdbola13 = Integer.parseInt(jogos.get(count).getb13());
                bdbola14 = Integer.parseInt(jogos.get(count).getb14());
            }else   if (jogos.get(count).getNumJogosdb() == 15) {
                bdbola7 = Integer.parseInt(jogos.get(count).getb7());
                bdbola8 = Integer.parseInt(jogos.get(count).getb8());
                bdbola9 = Integer.parseInt(jogos.get(count).getb9());
                bdbola10 = Integer.parseInt(jogos.get(count).getb10());
                bdbola11 = Integer.parseInt(jogos.get(count).getb11());
                bdbola12 = Integer.parseInt(jogos.get(count).getb12());
                bdbola13 = Integer.parseInt(jogos.get(count).getb13());
                bdbola14 = Integer.parseInt(jogos.get(count).getb14());
                bdbola15 = Integer.parseInt(jogos.get(count).getb15());
            }

            numacertos = 0;
            for(int i=0;i<=5;i++) {
                if (jogo[i] == bdbola1 || jogo[i] == bdbola2 || jogo[i] == bdbola3 || jogo[i] ==
                        bdbola4 || jogo[i] == bdbola5 || jogo[i] == bdbola6 || jogo[i] == bdbola7
                        || jogo[i] == bdbola8 || jogo[i] == bdbola9 || jogo[i] == bdbola10 ||
                        jogo[i] == bdbola11 || jogo[i] == bdbola12 || jogo[i] == bdbola13 ||
                        jogo[i] == bdbola14 || jogo[i] == bdbola15 ){
                    numacertos = numacertos + 1;
                }
            }

            if (numacertos == 4){
                quadra = quadra + 1;
            } else if (numacertos == 5){
                quina = quina + 1;
            } else if(numacertos ==6){
                sena = sena + 1;
            }
        }

        // Atualiza a tela com o numero de jogos acertados com 4 , 5 e 6 numeros
        resultado_sena.setText("" + sena);
        resultado_quina.setText("" + quina);
        resultado_quadra.setText("" + quadra);

        TextView msgparabens = (TextView) findViewById(R.id.mmsgparabens);
        if (sena!=0 || quadra != 0 || quina!=0 ){

            msgparabens.setVisibility(View.VISIBLE);
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(ConferirJogoManualActivity.this).create();
            alertDialog.setTitle("Alerta");
            alertDialog.setMessage("Não existem jogos premiados!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            msgparabens.setVisibility(View.GONE);

        }
    }

    public void rangePermitido(final Context context){


        int [] valida = new int[6];

        valida[0] = R.id.mcfb1;
        valida[1] = R.id.mcfb2;
        valida[2] = R.id.mcfb3;
        valida[3] = R.id.mcfb4;
        valida[4] = R.id.mcfb5;
        valida[5] = R.id.mcfb6;

        for(int i=0;i<=5;i++) {
            // Limite a digitação
            EditText et = (EditText) findViewById(valida[i]);
            et.setFilters(new InputFilter[]{new InputFilterMinMax("1", "60")});

            et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){

                        Toast toast= Toast.makeText(context,
                                "Números de 1 a 60", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();


                    }
                }
            });
        }
    }

}
