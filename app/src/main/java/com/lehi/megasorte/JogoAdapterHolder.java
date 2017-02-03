package com.lehi.megasorte;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gunaseelan on 11-12-2015.
 * Simple adapter class, used for show all numbers in list
 */
public class JogoAdapterHolder extends RecyclerView.Adapter<JogoAdapterHolder.ViewHolder> implements View.OnClickListener  {

    ArrayList<Jogo> jogos;


    public JogoAdapterHolder(List<Jogo> jogos) {
        this.jogos = new ArrayList<>(jogos);

    }


    @Override
    public void onClick(View view) {
        int i = 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_meus_jogos, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(jogos.get(position));

        //in some cases, it will prevent unwanted situations
        holder.checkbox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.checkbox.setChecked(jogos.get(position).isSelected());

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                jogos.get(holder.getAdapterPosition()).setSelected(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jogos.size();
    }




    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        // each data item is just a string in this case
        private TextView b1;
        private TextView b2;
        private TextView b3;
        private TextView b4;
        private TextView b5;
        private TextView b6;
        private TextView b7;
        private TextView b8;
        private TextView b9;
        private TextView b10;
        private TextView b11;
        private TextView b12;
        private TextView b13;
        private TextView b14;
        private TextView b15;
        private CheckBox checkbox;

        public ViewHolder(View v) {
            super(v);

            b1 = (TextView) v.findViewById(R.id.Tb1);
            b2 = (TextView) v.findViewById(R.id.Tb2);
            b3 = (TextView) v.findViewById(R.id.Tb3);
            b4 = (TextView) v.findViewById(R.id.Tb4);
            b5 = (TextView) v.findViewById(R.id.Tb5);
            b6 = (TextView) v.findViewById(R.id.Tb6);
            b7 = (TextView) v.findViewById(R.id.Tb7);
            b8 = (TextView) v.findViewById(R.id.Tb8);
            b9 = (TextView) v.findViewById(R.id.Tb9);
            b10 = (TextView) v.findViewById(R.id.Tb10);
            b11 = (TextView) v.findViewById(R.id.Tb11);
            b12 = (TextView) v.findViewById(R.id.Tb12);
            b13 = (TextView) v.findViewById(R.id.Tb13);
            b14 = (TextView) v.findViewById(R.id.Tb14);
            b15 = (TextView) v.findViewById(R.id.Tb15);
            checkbox = (CheckBox) v.findViewById(R.id.checkBox_selecionar);


        }

        public void bindData(Jogo jogo) {
            b1.setText(jogo.getb1());
            b2.setText(jogo.getb2());
            b3.setText(jogo.getb3());
            b4.setText(jogo.getb4());
            b5.setText(jogo.getb5());
            b6.setText(jogo.getb6());
            b7.setText(jogo.getb7());
            b8.setText(jogo.getb8());
            b9.setText(jogo.getb9());
            b10.setText(jogo.getb10());
            b11.setText(jogo.getb11());
            b12.setText(jogo.getb12());
            b13.setText(jogo.getb13());
            b14.setText(jogo.getb14());
            b15.setText(jogo.getb15());

            if (jogo.getNumJogosdb() == 7) {
             //   linhaDois.setVisibility(View.VISIBLE);
             //   linhatres.setVisibility(View.GONE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.GONE);
                b9.setVisibility(View.GONE);
                b10.setVisibility(View.GONE);
                b11.setVisibility(View.GONE);
                b12.setVisibility(View.GONE);
                b13.setVisibility(View.GONE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);

            }else if (jogo.getNumJogosdb() == 8){
             //   inhaDois.setVisibility(View.VISIBLE);
             //   inhatres.setVisibility(View.GONE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.GONE);
                b10.setVisibility(View.GONE);
                b11.setVisibility(View.GONE);
                b12.setVisibility(View.GONE);
                b13.setVisibility(View.GONE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);
            }else if (jogo.getNumJogosdb() == 9){
             //   linhaDois.setVisibility(View.VISIBLE);
             //   linhatres.setVisibility(View.GONE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.GONE);
                b11.setVisibility(View.GONE);
                b12.setVisibility(View.GONE);
                b13.setVisibility(View.GONE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);
            }else if (jogo.getNumJogosdb() == 10){
             //   linhaDois.setVisibility(View.VISIBLE);
             //   linhatres.setVisibility(View.GONE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                b11.setVisibility(View.GONE);
                b12.setVisibility(View.GONE);
                b13.setVisibility(View.GONE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);
            }else if (jogo.getNumJogosdb() == 11){
              //  linhaDois.setVisibility(View.VISIBLE);
              //  linhatres.setVisibility(View.GONE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                b11.setVisibility(View.VISIBLE);
                b12.setVisibility(View.GONE);
                b13.setVisibility(View.GONE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);
            }else if (jogo.getNumJogosdb() == 12){
              //  linhaDois.setVisibility(View.VISIBLE);
              //  linhatres.setVisibility(View.GONE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                b11.setVisibility(View.VISIBLE);
                b12.setVisibility(View.VISIBLE);
                b13.setVisibility(View.GONE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);
            }else if (jogo.getNumJogosdb() == 13){
               // linhaDois.setVisibility(View.VISIBLE);
              //  linhatres.setVisibility(View.VISIBLE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                b11.setVisibility(View.VISIBLE);
                b12.setVisibility(View.VISIBLE);
                b13.setVisibility(View.VISIBLE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);
            }else if (jogo.getNumJogosdb() == 14){
             //   linhaDois.setVisibility(View.VISIBLE);
             //   linhatres.setVisibility(View.VISIBLE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                b11.setVisibility(View.VISIBLE);
                b12.setVisibility(View.VISIBLE);
                b13.setVisibility(View.VISIBLE);
                b14.setVisibility(View.VISIBLE);
                b15.setVisibility(View.GONE);
            }else if (jogo.getNumJogosdb() == 15){
              //  linhaDois.setVisibility(View.VISIBLE);
             //   linhatres.setVisibility(View.VISIBLE);
                b7.setVisibility(View.VISIBLE);
                b8.setVisibility(View.VISIBLE);
                b9.setVisibility(View.VISIBLE);
                b10.setVisibility(View.VISIBLE);
                b11.setVisibility(View.VISIBLE);
                b12.setVisibility(View.VISIBLE);
                b13.setVisibility(View.VISIBLE);
                b14.setVisibility(View.VISIBLE);
                b15.setVisibility(View.VISIBLE);
            }else {
             //   linhaDois.setVisibility(View.GONE);
             //   linhatres.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                b8.setVisibility(View.GONE);
                b9.setVisibility(View.GONE);
                b10.setVisibility(View.GONE);
                b11.setVisibility(View.GONE);
                b12.setVisibility(View.GONE);
                b13.setVisibility(View.GONE);
                b14.setVisibility(View.GONE);
                b15.setVisibility(View.GONE);
            }

        }
    }
}