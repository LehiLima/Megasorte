package com.lehi.megasorte;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class Valor extends Fragment {

    private DBHelper mydb  = new DBHelper(getContext());
    private double valorTotal;
    private int numParticip;

    public Valor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_valor, container, false);

        // Anuncios
        AdView adView = (AdView) rootView.findViewById(R.id.adviewvalor);
        AdRequest adRequest = new  AdRequest.Builder().build();
        adView.loadAd(adRequest);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab_mail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydb  = new DBHelper(getContext());
                String email = "";
                String emailbody= "";
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");

                //Carrega os emails para uma String
                ArrayList<String> listEmail = mydb.getallemail();
                for(int cont = 0;cont<=listEmail.size()-1;cont++){
                    if(cont==0){
                        email = listEmail.get(cont);
                    }else{
                        email = email + ", " + listEmail.get(cont)  ;
                    }
                }

                TextView tvValorTotal = (TextView) rootView.findViewById(R.id.Valor_total_jogos);
                TextView textView = (TextView) rootView.findViewById(R.id.total_jogos);
                TextView tvValorParticip = (TextView) rootView.findViewById(R.id.num_participantes);
                TextView tvValorPorPessoa = (TextView) rootView.findViewById(R.id.valor_por_participante);
                TextView tvValorPago = (TextView) rootView.findViewById(R.id.valor_pago);
                TextView tvPagantes = (TextView) rootView.findViewById(R.id.pagantes);

                emailbody = "Valor Total :" + tvValorTotal.getText().toString();
                emailbody = emailbody + "\n" + textView.getText().toString() ;
                emailbody = emailbody + "\n" + tvValorParticip.getText().toString();
                emailbody = emailbody + "\n" + tvValorPorPessoa.getText().toString();
                emailbody = emailbody + "\n" + tvValorPago.getText().toString();
                emailbody = emailbody + "\n" + tvPagantes.getText().toString();

                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
                i.putExtra(Intent.EXTRA_SUBJECT, "Bolão Mega Sena (Mega Sorte)");
                i.putExtra(Intent.EXTRA_TEXT   , emailbody );
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "There are no email clients installed.", Toast
                            .LENGTH_SHORT).show();
                }
            }
        });
        atualizaUI(rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        atualizaUI(getView());

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart() {
        super.onStart();
        atualizaUI(getView());
    }





private void atualizaUI(View view){
    mydb  = new DBHelper(getContext());
    valorTotal =  mydb.getvalorJogos();
    numParticip = mydb.getnumParticip();


    TextView tvValorTotal = (TextView) view.findViewById(R.id.Valor_total_jogos);
    tvValorTotal.setText("" + formatBigDecimal(valorTotal));

    TextView textView = (TextView) view.findViewById(R.id.total_jogos);
    textView.setText("Número de Jogos:    "+  mydb.getnumJogos());

    TextView tvValorParticip = (TextView) view.findViewById(R.id.num_participantes);
    tvValorParticip.setText("Total de pessoas:    " + numParticip );

    TextView tvValorPorPessoa = (TextView) view.findViewById(R.id.valor_por_participante);
    tvValorPorPessoa.setText("Valor por pessoa:    "+   formatBigDecimal((valorTotal/numParticip)));

    TextView tvValorPago = (TextView) view.findViewById(R.id.valor_pago);
    tvValorPago.setText("Valor Pago:    "+   formatBigDecimal((valorTotal/numParticip)
    * mydb.getnumParticipPago()));

    TextView tvPagantes = (TextView) view.findViewById(R.id.pagantes);
    tvPagantes.setText("Número de pagantes:    "+
            mydb.getnumParticipPago());
  }
    private String formatBigDecimal(double numero){
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ROOT);
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);

        return df.format(numero);
    }


}
