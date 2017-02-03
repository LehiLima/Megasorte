package com.lehi.megasorte;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lehi on 31/08/2016.
 */
public class jogoAdapter extends ArrayAdapter<Jogo>  {


    private static final String LOG_TAG = jogoAdapter.class.getSimpleName();



    //Construtor
    public jogoAdapter(Activity context,ArrayList<Jogo> jogo){
        super(context,0,jogo);

    }

    public View getView(int position, final View convertView, ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_meus_jogos, parent, false);
        }



        String nomeActivity  = (String) parent.getContext().getClass().getSimpleName();

        CheckBox ckSelec = (CheckBox) listItemView.findViewById(R.id.checkBox_selecionar);

        //Mostra o checkBox somente na tela de selecionar
        if (nomeActivity.equals("selecionarActivity")){

            ckSelec.setVisibility(View.VISIBLE);
        }else {
            ckSelec.setVisibility(View.GONE);
        }

    // declara objeto
        Jogo jogo = getItem(position);
        // Lina com a view com o Layout
        TextView tb1 = (TextView) listItemView.findViewById(R.id.Tb1);
        TextView tb2 = (TextView) listItemView.findViewById(R.id.Tb2);
        TextView tb3 = (TextView) listItemView.findViewById(R.id.Tb3);
        TextView tb4 = (TextView) listItemView.findViewById(R.id.Tb4);
        TextView tb5 = (TextView) listItemView.findViewById(R.id.Tb5);
        TextView tb6 = (TextView) listItemView.findViewById(R.id.Tb6);
        TextView tb7 = (TextView) listItemView.findViewById(R.id.Tb7);
        TextView tb8 = (TextView) listItemView.findViewById(R.id.Tb8);
        TextView tb9 = (TextView) listItemView.findViewById(R.id.Tb9);
        TextView tb10 = (TextView) listItemView.findViewById(R.id.Tb10);
        TextView tb11 = (TextView) listItemView.findViewById(R.id.Tb11);
        TextView tb12 = (TextView) listItemView.findViewById(R.id.Tb12);
        TextView tb13 = (TextView) listItemView.findViewById(R.id.Tb13);
        TextView tb14 = (TextView) listItemView.findViewById(R.id.Tb14);
        TextView tb15 = (TextView) listItemView.findViewById(R.id.Tb15);

        LinearLayout linhaDois = (LinearLayout) listItemView.findViewById(R.id.linha_dois);
        LinearLayout linhatres = (LinearLayout) listItemView.findViewById(R.id.linha_tres);
        TextView tvnumjogos = (TextView) listItemView.findViewById(R.id.num_Jogos);

        tvnumjogos.setText("" + jogo.getNumJogosdb());
        tb1.setText(jogo.getb1());
        tb2.setText(jogo.getb2());
        tb3.setText(jogo.getb3());
        tb4.setText(jogo.getb4());
        tb5.setText(jogo.getb5());
        tb6.setText(jogo.getb6());
        tb7.setText(jogo.getb7());
        tb8.setText(jogo.getb8());
        tb9.setText(jogo.getb9());
        tb10.setText(jogo.getb10());
        tb11.setText(jogo.getb11());
        tb12.setText(jogo.getb12());
        tb13.setText(jogo.getb13());
        tb14.setText(jogo.getb14());
        tb15.setText(jogo.getb15());

        if (jogo.getNumJogosdb() == 7) {
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.GONE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.GONE);
            tb9.setVisibility(View.GONE);
            tb10.setVisibility(View.GONE);
            tb11.setVisibility(View.GONE);
            tb12.setVisibility(View.GONE);
            tb13.setVisibility(View.GONE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);

        }else if (jogo.getNumJogosdb() == 8){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.GONE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.GONE);
            tb10.setVisibility(View.GONE);
            tb11.setVisibility(View.GONE);
            tb12.setVisibility(View.GONE);
            tb13.setVisibility(View.GONE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);
        }else if (jogo.getNumJogosdb() == 9){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.GONE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.VISIBLE);
            tb10.setVisibility(View.GONE);
            tb11.setVisibility(View.GONE);
            tb12.setVisibility(View.GONE);
            tb13.setVisibility(View.GONE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);
        }else if (jogo.getNumJogosdb() == 10){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.GONE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.VISIBLE);
            tb10.setVisibility(View.VISIBLE);
            tb11.setVisibility(View.GONE);
            tb12.setVisibility(View.GONE);
            tb13.setVisibility(View.GONE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);
        }else if (jogo.getNumJogosdb() == 11){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.GONE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.VISIBLE);
            tb10.setVisibility(View.VISIBLE);
            tb11.setVisibility(View.VISIBLE);
            tb12.setVisibility(View.GONE);
            tb13.setVisibility(View.GONE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);
        }else if (jogo.getNumJogosdb() == 12){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.GONE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.VISIBLE);
            tb10.setVisibility(View.VISIBLE);
            tb11.setVisibility(View.VISIBLE);
            tb12.setVisibility(View.VISIBLE);
            tb13.setVisibility(View.GONE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);
        }else if (jogo.getNumJogosdb() == 13){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.VISIBLE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.VISIBLE);
            tb10.setVisibility(View.VISIBLE);
            tb11.setVisibility(View.VISIBLE);
            tb12.setVisibility(View.VISIBLE);
            tb13.setVisibility(View.VISIBLE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);
        }else if (jogo.getNumJogosdb() == 14){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.VISIBLE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.VISIBLE);
            tb10.setVisibility(View.VISIBLE);
            tb11.setVisibility(View.VISIBLE);
            tb12.setVisibility(View.VISIBLE);
            tb13.setVisibility(View.VISIBLE);
            tb14.setVisibility(View.VISIBLE);
            tb15.setVisibility(View.GONE);
        }else if (jogo.getNumJogosdb() == 15){
            linhaDois.setVisibility(View.VISIBLE);
            linhatres.setVisibility(View.VISIBLE);
            tb7.setVisibility(View.VISIBLE);
            tb8.setVisibility(View.VISIBLE);
            tb9.setVisibility(View.VISIBLE);
            tb10.setVisibility(View.VISIBLE);
            tb11.setVisibility(View.VISIBLE);
            tb12.setVisibility(View.VISIBLE);
            tb13.setVisibility(View.VISIBLE);
            tb14.setVisibility(View.VISIBLE);
            tb15.setVisibility(View.VISIBLE);
        }else {
            linhaDois.setVisibility(View.GONE);
            linhatres.setVisibility(View.GONE);
            tb7.setVisibility(View.GONE);
            tb8.setVisibility(View.GONE);
            tb9.setVisibility(View.GONE);
            tb10.setVisibility(View.GONE);
            tb11.setVisibility(View.GONE);
            tb12.setVisibility(View.GONE);
            tb13.setVisibility(View.GONE);
            tb14.setVisibility(View.GONE);
            tb15.setVisibility(View.GONE);
        }


        return listItemView;
    }



}
