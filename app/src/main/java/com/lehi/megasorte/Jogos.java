package com.lehi.megasorte;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Jogos extends Fragment  implements AdapterView.OnItemSelectedListener {

    private Jogo mJogo;

    public Jogos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_jogos, container, false);


        // Anuncios
        AdView adView = (AdView) rootView.findViewById(R.id.adview);
        AdRequest adRequest = new  AdRequest.Builder().build();
        adView.loadAd(adRequest);

        mJogo = new Jogo(getContext());

        Button myBtn = (Button) rootView.findViewById(R.id.gerarJogo);
        myBtn.requestFocus();
        /**
         * Cria Listenners para os meus botões neste fragmento
         */
        Button buttonGerarJogo = (Button) rootView.findViewById(R.id.gerarJogo);
        // Register the onClick listener with the implementation above
        buttonGerarJogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                mJogo.preencheBolas(rootView);
            }
        });


        Button buttonSalvar = (Button) rootView.findViewById(R.id.salvar);
        // Register the onClick listener with the implementation above
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                EditText b1 = (EditText) rootView.findViewById(R.id.b1);
                EditText b2 = (EditText) rootView.findViewById(R.id.b2);
                EditText b3 = (EditText) rootView.findViewById(R.id.b3);
                EditText b4 = (EditText) rootView.findViewById(R.id.b4);
                EditText b5 = (EditText) rootView.findViewById(R.id.b5);
                EditText b6 = (EditText) rootView.findViewById(R.id.b6);
                EditText b7 = (EditText) rootView.findViewById(R.id.b7);
                EditText b8 = (EditText) rootView.findViewById(R.id.b8);
                EditText b9 = (EditText) rootView.findViewById(R.id.b9);
                EditText b10 = (EditText) rootView.findViewById(R.id.b10);
                EditText b11 = (EditText) rootView.findViewById(R.id.b11);
                EditText b12 = (EditText) rootView.findViewById(R.id.b12);
                EditText b13 = (EditText) rootView.findViewById(R.id.b13);
                EditText b14 = (EditText) rootView.findViewById(R.id.b14);
                EditText b15 = (EditText) rootView.findViewById(R.id.b15);
                if (b1.length() == 0 || b2.length() == 0 || b3.length() == 0 || b4.length() == 0
                        || b5.length() == 0 || b6.length() == 0 || (b7.length() == 0 && b7
                        .getVisibility() == rootView.VISIBLE)|| (b8.length() == 0 && b8
                        .getVisibility() == rootView.VISIBLE)|| (b9.length() == 0 && b9
                        .getVisibility() == rootView.VISIBLE)|| (b10.length() == 0 && b10
                        .getVisibility() == rootView.VISIBLE)|| (b11.length() == 0 && b11
                        .getVisibility() == rootView.VISIBLE)|| (b12.length() == 0 && b12
                        .getVisibility() == rootView.VISIBLE)|| (b13.length() == 0 && b13
                        .getVisibility() == rootView.VISIBLE)|| (b14.length() == 0 && b14
                        .getVisibility() == rootView.VISIBLE)|| (b15.length() == 0 && b15
                        .getVisibility() == rootView.VISIBLE)){
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
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

                    mJogo.salvar(rootView);
                    mJogo.limpaBolas(rootView);
                }
            }
        });



        // Spinner element
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("6");
        categories.add("7");
        categories.add("8");
        categories.add("9");
        categories.add("10");
        categories.add("11");
        categories.add("12");
        categories.add("13");
        categories.add("14");
        categories.add("15");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        return rootView;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        int numJogos = Integer.parseInt(parent.getItemAtPosition(position).toString());

        mostraBolas(getView(),numJogos);
        // Showing selected spinner item

        mJogo.rangePermitido(getView(),getContext(),numJogos);
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    //Libera campos de acordo com numero de jogos
    public void mostraBolas(View view,int numJogos){
        //Busca os objetos no Layout

        EditText bola7 = (EditText) view.findViewById(R.id.b7);
        EditText bola8 = (EditText) view.findViewById(R.id.b8);
        EditText bola9 = (EditText) view.findViewById(R.id.b9);
        EditText bola10 = (EditText) view.findViewById(R.id.b10);
        EditText bola11 = (EditText) view.findViewById(R.id.b11);
        EditText bola12 = (EditText) view.findViewById(R.id.b12);
        EditText bola13 = (EditText) view.findViewById(R.id.b13);
        EditText bola14 = (EditText) view.findViewById(R.id.b14);
        EditText bola15 = (EditText) view.findViewById(R.id.b15);



        // Mostra bolas
        if (numJogos == 7) {
            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.GONE);
            bola9.setVisibility(view.GONE);
            bola10.setVisibility(view.GONE);
            bola11.setVisibility(view.GONE);
            bola12.setVisibility(view.GONE);
            bola13.setVisibility(view.GONE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);

        } else if (numJogos == 8) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.GONE);
            bola10.setVisibility(view.GONE);
            bola11.setVisibility(view.GONE);
            bola12.setVisibility(view.GONE);
            bola13.setVisibility(view.GONE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);
        } else if (numJogos == 9) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.VISIBLE);
            bola10.setVisibility(view.GONE);
            bola11.setVisibility(view.GONE);
            bola12.setVisibility(view.GONE);
            bola13.setVisibility(view.GONE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);
        }else if (numJogos == 10) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.VISIBLE);
            bola10.setVisibility(view.VISIBLE);
            bola11.setVisibility(view.GONE);
            bola12.setVisibility(view.GONE);
            bola13.setVisibility(view.GONE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);
        }else if (numJogos == 11) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.VISIBLE);
            bola10.setVisibility(view.VISIBLE);
            bola11.setVisibility(view.VISIBLE);
            bola12.setVisibility(view.GONE);
            bola13.setVisibility(view.GONE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);
        } else if (numJogos == 12) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.VISIBLE);
            bola10.setVisibility(view.VISIBLE);
            bola11.setVisibility(view.VISIBLE);
            bola12.setVisibility(view.VISIBLE);
            bola13.setVisibility(view.GONE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);
        }else if (numJogos == 13) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.VISIBLE);
            bola10.setVisibility(view.VISIBLE);
            bola11.setVisibility(view.VISIBLE);
            bola12.setVisibility(view.VISIBLE);
            bola13.setVisibility(view.VISIBLE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);

        }else if (numJogos == 14) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.VISIBLE);
            bola10.setVisibility(view.VISIBLE);
            bola11.setVisibility(view.VISIBLE);
            bola12.setVisibility(view.VISIBLE);
            bola13.setVisibility(view.VISIBLE);
            bola14.setVisibility(view.VISIBLE);
            bola15.setVisibility(view.GONE);

        }else if (numJogos == 15) {

            bola7.setVisibility(view.VISIBLE);
            bola8.setVisibility(view.VISIBLE);
            bola9.setVisibility(view.VISIBLE);
            bola10.setVisibility(view.VISIBLE);
            bola11.setVisibility(view.VISIBLE);
            bola12.setVisibility(view.VISIBLE);
            bola13.setVisibility(view.VISIBLE);
            bola14.setVisibility(view.VISIBLE);
            bola15.setVisibility(view.VISIBLE);

        } else {
            bola7.setVisibility(view.GONE);
            bola8.setVisibility(view.GONE);
            bola9.setVisibility(view.GONE);
            bola10.setVisibility(view.GONE);
            bola11.setVisibility(view.GONE);
            bola12.setVisibility(view.GONE);
            bola13.setVisibility(view.GONE);
            bola14.setVisibility(view.GONE);
            bola15.setVisibility(view.GONE);

        }

    }

}
