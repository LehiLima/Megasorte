package com.lehi.megasorte;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bolao extends Fragment {

    private Participantes mPart = new Participantes(getContext());

    private DBHelper mydb  = new DBHelper(getContext());

    public Bolao() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_bolao, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ParticipanteActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(rootView.findViewById(R.id.list_participantes));

        mydb  = new DBHelper(getContext());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        mPart.carregaPart(getActivity());
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(Menu.NONE, 1, Menu.NONE, "Excluir");
        contextMenu.add(Menu.NONE, 2, Menu.NONE, "Marcar pago");
        contextMenu.add(Menu.NONE, 3, Menu.NONE, "Desmarcar pago");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = -1;

        ListView lv = (ListView) getView().findViewById(R.id.list_participantes);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Participantes obj = (Participantes) lv.getItemAtPosition(info.position);

        switch (item.getItemId()) {
            case 1:

                /*
                *  Apaga registo
                */
                mydb.deleteParticip(obj.getmId());
                Toast.makeText(getContext()," Registro removido com sucesso" ,Toast.LENGTH_SHORT).show();
                obj.carregaPart(getActivity());

                return true;
            case 2:
                mydb.updateParticip(obj.getmId(),1);
                Toast.makeText(getContext()," Registro atualizado com sucesso" ,Toast.LENGTH_SHORT)
                        .show();
                obj.carregaPart(getActivity());

                return true;

            case 3:
                mydb.updateParticip(obj.getmId(),0);
                Toast.makeText(getContext()," Registro atualizado com sucesso" ,Toast.LENGTH_SHORT)
                        .show();
                obj.carregaPart(getActivity());

                return true;
        }
        return super.onContextItemSelected(item);
    }


}
