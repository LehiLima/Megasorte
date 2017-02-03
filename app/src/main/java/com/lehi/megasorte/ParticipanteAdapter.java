package com.lehi.megasorte;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lehi on 06/09/2016.
 */
public class ParticipanteAdapter extends ArrayAdapter<Participantes> {
    private static final String LOG_TAG = jogoAdapter.class.getSimpleName();

    //Construtor
    public ParticipanteAdapter(Activity context, ArrayList<Participantes> part){
        super(context,0,part);

    }
    static class ViewHolder {
        protected TextView tvEmail, tvnome, pagook, tvpago ;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_participantes, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvEmail = (TextView) listItemView.findViewById(R.id.email_bolao);
            viewHolder.tvnome = (TextView) listItemView.findViewById(R.id.nome_bolao);
            viewHolder.pagook = (TextView) listItemView.findViewById(R.id.pago_ok);
            viewHolder.tvpago = (TextView) listItemView.findViewById(R.id.pago);

            listItemView.setTag(viewHolder);
            listItemView.setTag(R.id.email_bolao,viewHolder.tvEmail);
            listItemView.setTag(R.id.nome_bolao,viewHolder.tvnome);
            listItemView.setTag(R.id.pago_ok,viewHolder.pagook);
            listItemView.setTag(R.id.pago,viewHolder.tvpago);
        }else {
            viewHolder = (ViewHolder) listItemView.getTag();
        }


        // declara objeto
        Participantes obj = getItem(position);

        viewHolder.tvEmail.setText(obj.getmEmail());
        viewHolder.tvnome.setText(obj.getmNome());
        if (obj.getmPago() == 1) {
            viewHolder.pagook.setText("OK");
            viewHolder.pagook.setBackgroundResource(R.drawable.bola_circle_dark);
            viewHolder.tvpago.setText("Pago");
        }else{
            viewHolder.pagook.setBackgroundResource(R.drawable.bola_circle);
            viewHolder.pagook.setText("");
            viewHolder.tvpago.setText("");

        }


        return listItemView;
    }
}
