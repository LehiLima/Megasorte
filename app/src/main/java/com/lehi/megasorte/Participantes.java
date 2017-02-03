package com.lehi.megasorte;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Lehi on 06/09/2016.
 */
public class Participantes {

    private int mId;
    private String mEmail;
    private String mNome;



    private int mPago;
    public DBHelper mydb;


    public Participantes(int id, String email,String nome, int pago) {
        this.mId = id;
        this.mEmail = email;
        this.mNome = nome;
        this.mPago = pago;
    }
    public Participantes(int id, String email,String nome) {
        this.mId = id;
        this.mEmail = email;
        this.mNome = nome;
    }

    public Participantes() {

    }


    public Participantes(Context context){

        DBHelper mydb = new DBHelper(context);

    }
    public int getmId() {
        return mId;
    }
    public int getmPago() {
        return mPago;
    }

    public String getmNome() {
        return mNome;
    }

    public String getmEmail() {
        return mEmail;
    }



    public void carregaPart(final Activity activity){

            /*
            * Carrega o listView com os dados da tabela jogos
             */
        mydb = new DBHelper(activity.getApplicationContext());
        final ArrayList<Participantes> part = new ArrayList<Participantes>();

        part.addAll(mydb.getAllParticipantes());
        final ArrayAdapter<Participantes> Partadapter = new ParticipanteAdapter(activity,part);
        //final ArrayAdapter<Jogo> jogoadapter = new JogoAdapterHolder(activity,jogos);
        //JogoAdapterHolder adapter = new JogoAdapterHolder(jogos);
        final ListView listView = (ListView) activity.findViewById(R.id.list_participantes);
//            listView.setLayoutManager(new LinearLayoutManager(activity));
//            listView.setHasFixedSize(true);
        listView.setAdapter(Partadapter);

//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                Toast.makeText(activity.getApplicationContext(),"ttt",Toast.LENGTH_SHORT).show();
//
//
//            }
//        });

    }
}
