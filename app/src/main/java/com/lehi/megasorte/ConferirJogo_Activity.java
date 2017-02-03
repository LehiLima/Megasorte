package com.lehi.megasorte;

import android.app.LoaderManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;

public class ConferirJogo_Activity extends AppCompatActivity implements  android.app.LoaderManager.LoaderCallbacks<Jogo>{
    private static final String MEGA_REQUEST_URL =
            "http://wsloterias.azurewebsites.net/api/sorteio/getresultado/1";
    private static final int JOGO_LOADER_ID = 1;

    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferir_jogo_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Anuncios
        AdView adView = (AdView) findViewById(R.id.adviewconferir);
        AdRequest adRequest = new  AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // Get a reference to the LoaderManager, in order to interact with loaders.
       //android.app.LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
      //  loaderManager.initLoader(JOGO_LOADER_ID, null, this);

        // Botão voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        TextView textmsgconexao = (TextView) findViewById(R.id.msg_sem_conexao);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.conferir_jogo_layout);
        View loadingIndicator = findViewById(R.id.carregar);
        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {



            textmsgconexao.setVisibility(View.GONE);
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(JOGO_LOADER_ID, null, this);


        } else {


            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            textmsgconexao.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.GONE);
            Toast.makeText(this,"Sem Conexão com a Inteernet ",Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public android.content.Loader<Jogo> onCreateLoader(int i, Bundle bundle) {
        return new ConfereJogoLoader(this,MEGA_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(android.content.Loader<Jogo> loader, Jogo jogo) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.conferir_jogo_layout);
        linearLayout.setVisibility(View.VISIBLE);
        // Atualiza a tela com os numeros do ultimo jogo da mega sena
        TextView b1 = (TextView) findViewById(R.id.cfb1);
        TextView b2 = (TextView) findViewById(R.id.cfb2);
        TextView b3 = (TextView) findViewById(R.id.cfb3);
        TextView b4 = (TextView) findViewById(R.id.cfb4);
        TextView b5 = (TextView) findViewById(R.id.cfb5);
        TextView b6 = (TextView) findViewById(R.id.cfb6);
        TextView concurso = (TextView) findViewById(R.id.num_concurso);


        // Ordena os valores na ordem decresente
        int [] ordenarjogo = {Integer.parseInt(jogo.getb1()),Integer.parseInt(jogo.getb2()),Integer.parseInt(jogo.getb3()),Integer.parseInt(jogo.getb4()),Integer.parseInt(jogo.getb5()),Integer.parseInt(jogo.getb6())};
        Arrays.sort(ordenarjogo);

        // jogo os valores para a view

        b1.setText("" + ordenarjogo[0]);
        b2.setText("" + ordenarjogo[1]);
        b3.setText("" + ordenarjogo[2]);
        b4.setText("" + ordenarjogo[3]);
        b5.setText("" + ordenarjogo[4]);
        b6.setText("" + ordenarjogo[5]);
        concurso.setText("" + jogo.getid());

        View loadingIndicator = findViewById(R.id.carregar);
        loadingIndicator.setVisibility(View.GONE);

        conferirJogo();
    }

    @Override
    public void onLoaderReset(android.content.Loader<Jogo> loader) {

    }


    public void conferirJogo(){
        int sena = 0,quina = 0,quadra = 0,numacertos;


        // inicia o db para retornar todos os jogos na base
        DBHelper mydb = new DBHelper(getApplicationContext());
        final ArrayList<Jogo> jogos = new ArrayList<Jogo>();

        jogos.addAll(mydb.getAllJogos());

        //Link com a tela para buscar os valores

        TextView b1 = (TextView) findViewById(R.id.cfb1);
        TextView b2 = (TextView) findViewById(R.id.cfb2);
        TextView b3 = (TextView) findViewById(R.id.cfb3);
        TextView b4 = (TextView) findViewById(R.id.cfb4);
        TextView b5 = (TextView) findViewById(R.id.cfb5);
        TextView b6 = (TextView) findViewById(R.id.cfb6);
        TextView resultado_sena = (TextView) findViewById(R.id.senanumero);
        TextView resultado_quina = (TextView) findViewById(R.id.quinanumero);
        TextView resultado_quadra = (TextView) findViewById(R.id.quadranumero);

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

        if (sena!=0 || quadra != 0 || quina!=0 ){
            TextView msgparabens = (TextView) findViewById(R.id.msgparabens);
            msgparabens.setVisibility(View.VISIBLE);
        }
    }

}
