package com.lehi.megasorte;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeusJogos extends Fragment {

    private ArrayList<Toast> listToasts = new ArrayList<Toast>();

    private DBHelper mydb  = new DBHelper(getContext());
    private Jogo mJogo = new Jogo(getContext());
    private ViewPager mViewPager;

    public MeusJogos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_meus_jogos, container, false);

        mydb  = new DBHelper(getContext());
//        // Evento de click do botão Apagar Todos
//        Button buttonApagarTodos = (Button) rootView.findViewById(R.id.apagarTodos);
//        buttonApagarTodos.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mydb.deleteAllJogos();
//                // Atualiza após a deleção  List View
//                mJogo.carregaJogos(getActivity());
//                Toast t = Toast.makeText(getContext(), "Jogos Removido com sucesso", Toast.LENGTH_SHORT);
//                t.show();
//                listToasts.add(t);
//
//            }
//        });


        registerForContextMenu(rootView.findViewById(R.id.list));

        return rootView;
    }




    // Remove todos os Toasts
    private void killAllToast(){
        for(Toast t:listToasts){
            if(t!=null) {
                t.cancel();
            }
        }
        listToasts.clear();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStop() {
        super.onStop();
        // Remove toasts qrando sair da aplicação
        killAllToast();
       // Log.v("onStop frag Meus jogos","onStop Frag Meus jogos");
    }



    @Override
    public void onResume() {
        super.onResume();
          // Carrega List View
        mJogo.carregaJogos(getActivity());
       // ListView listView = (ListView) getView().findViewById(R.id.list);


    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(Menu.NONE, 0, Menu.NONE, "Excluir");

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = -1;

        switch (item.getItemId()) {
            case 0:
               // ListView listView = (ListView) getView().findViewById(R.id.list);
                //Recupera id para exclusão;

//
                ListView lv = (ListView) getView().findViewById(R.id.list);
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//
                Jogo obj = (Jogo) lv.getItemAtPosition(info.position);

//                Jogo obj = (Jogo) rv.;

                /*
                *  Apaga registo
                */
                 mydb.deleteJogos(obj.getid());
//
                Toast.makeText(getContext()," Registro removido com sucesso" ,Toast.LENGTH_SHORT).show();
//
                obj.carregaJogos(getActivity());


                return true;

        }
        return super.onContextItemSelected(item);
    }
}
