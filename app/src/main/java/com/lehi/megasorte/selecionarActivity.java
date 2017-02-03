package com.lehi.megasorte;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class selecionarActivity extends AppCompatActivity {
    private Menu mMenu;
    public DBHelper mydb;
    private RecyclerView list;
    private ImageView imageExcluir;
    private Button btMarcarTodos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_selecionar);
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

       

        mydb = new DBHelper(this);
        final ArrayList<Jogo> jogos = new ArrayList<Jogo>();

        jogos.addAll(mydb.getAllJogos());

        list = (RecyclerView) findViewById(R.id.list_selecionar);
        list.setLayoutManager(new LinearLayoutManager(this));
        JogoAdapterHolder adapter = new JogoAdapterHolder(jogos);
        list.setHasFixedSize(true);
        list.setAdapter(adapter);


        imageExcluir = (ImageView) findViewById(R.id.img_excluir);
        imageExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Mensgem de Confirmação


                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Deseja remover os jogos marcados?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                for (Jogo jogo : jogos) {
                                    if (jogo.isSelected()) {
                                        mydb.deleteJogos(jogo.getid());

                                    }
                                }
                                // atualiza tela
                                jogos.clear();
                                jogos.addAll(mydb.getAllJogos());
                                list = (RecyclerView) findViewById(R.id.list_selecionar);
                                list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                                JogoAdapterHolder adapter = new JogoAdapterHolder(jogos);
                                list.setHasFixedSize(true);
                                list.setAdapter(adapter);

                                Toast.makeText(getApplicationContext(), "Jogos removidos", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                AlertDialog d = builder.create();
                d.setTitle("Confirmar exclusão:");
                d.show();



            }
        });


        btMarcarTodos = (Button) findViewById(R.id.btnGetSelected);
        btMarcarTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Jogo jogo : jogos) {


                        jogo.setSelected(true);

                }
                // atualiza tela


                list = (RecyclerView) findViewById(R.id.list_selecionar);
                list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                JogoAdapterHolder adapter = new JogoAdapterHolder(jogos);
                list.setHasFixedSize(true);
                list.setAdapter(adapter);


            }
        });
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
//                Jogo selItem = (Jogo) adapter.getSelectedItem();
//
//            }
//        });

    }









}
