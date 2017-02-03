package com.lehi.megasorte;


import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lehi on 31/08/2016.
 */
public class Jogo {

    private boolean selected = false;
    private boolean isSelected;
    private int mid;
    private int mnumJogosdb;
    private String mb1;
    private String mb2;
    private String mb3;
    private String mb4;
    private String mb5;
    private String mb6;
    private String mb7;
    private String mb8;
    private String mb9;
    private String mb10;
    private String mb11;
    private String mb12;
    private String mb13;
    private String mb14;
    private String mb15;
    public DBHelper mydb;


    private int numJogos=6;



    // Construtor para 6 numeros com chkbox
    public Jogo(int id, int numjogodb, String b1 , String b2 , String b3 , String
            b4 , String b5 , String b6, String b7,String b8, String b9,String b10, String b11 ,
                String b12 , String b13,String b14, String b15){
        mid = id;
        mnumJogosdb = numjogodb;
        mb1 = b1;
        mb2 = b2;
        mb3 = b3;
        mb4 = b4;
        mb5 = b5;
        mb6 = b6;
        mb7 = b7;
        mb8 = b8;
        mb9 = b9;
        mb10 = b10;
        mb11 = b11;
        mb12 = b12;
        mb13 = b13;
        mb14 = b14;
        mb15 = b15;


    }


    // Construtor para 6 numeros com chkbox
    public Jogo(boolean selected, int id, String b1 , String b2 , String b3 , String b4 , String b5 , String b6 ){
        this.selected = selected;
        mid = id;
        mb1 = b1;
        mb2 = b2;
        mb3 = b3;
        mb4 = b4;
        mb5 = b5;
        mb6 = b6;

    }


    // Construtor sem chkbox
    public Jogo(int id, String b1 , String b2 , String b3 , String b4 , String b5 , String b6 ){

        mid = id;
        mb1 = b1;
        mb2 = b2;
        mb3 = b3;
        mb4 = b4;
        mb5 = b5;
        mb6 = b6;

    }

    // Construtor
    public Jogo(Context context){

        DBHelper mydb = new DBHelper(context);

    }
    // Construtor
    public Jogo(){



    }
//    public boolean getChk(){
//        return mchk;
//    }


    public  int getid(){
        return mid;
    }

    public  String getb1(){
        return mb1;
    }

    public  String getb2(){
        return mb2;
    }

    public  String getb3(){
        return mb3;
    }
    public  String getb4(){
        return mb4;
    }
    public  String getb5(){
        return mb5;
    }
    public  String getb6(){
        return mb6;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getb7() {
        return mb7;
    }

    public String getb8() {
        return mb8;
    }

    public String getb9() {
        return mb9;
    }

    public String getb10() {
        return mb10;
    }

    public String getb11() {
        return mb11;
    }

    public String getb12() {
        return mb12;
    }

    public String getb13() {
        return mb13;
    }

    public String getb14() {
        return mb14;
    }

    public String getb15() {
        return mb15;
    }

    public int getNumJogosdb() {
        return mnumJogosdb;
    }

    public void salvar(View view)
    {
        mydb = new DBHelper(view.getContext());

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        // vincula os layouts
        EditText b1 = (EditText) view.findViewById(R.id.b1);
        EditText b2 = (EditText) view.findViewById(R.id.b2);
        EditText b3 = (EditText) view.findViewById(R.id.b3);
        EditText b4 = (EditText) view.findViewById(R.id.b4);
        EditText b5 = (EditText) view.findViewById(R.id.b5);
        EditText b6 = (EditText) view.findViewById(R.id.b6);
        //
        EditText b7 = (EditText) view.findViewById(R.id.b7);
        EditText b8 = (EditText) view.findViewById(R.id.b8);
        EditText b9 = (EditText) view.findViewById(R.id.b9);
        EditText b10 = (EditText) view.findViewById(R.id.b10);
        EditText b11 = (EditText) view.findViewById(R.id.b11);
        EditText b12 = (EditText) view.findViewById(R.id.b12);
        EditText b13 = (EditText) view.findViewById(R.id.b13);
        EditText b14 = (EditText) view.findViewById(R.id.b14);
        EditText b15 = (EditText) view.findViewById(R.id.b15);



        int numJogotl = Integer.parseInt(spinner.getSelectedItem().toString());

        if(mydb.insertJogos(numJogotl , b1.getText().toString(), b2.getText().toString(), b3.getText().toString(), b4.getText().toString(), b5.getText().toString(),b6.getText().toString() , b7.getText().toString(),b8.getText().toString
                (),b9.getText().toString(),b10.getText().toString(),b11.getText().toString(),b12
                .getText().toString(),b13.getText().toString(),b14.getText().toString(),b15.getText
                ().toString() )){

            Toast.makeText(view.getContext(), "Jogo Salvo com sucesso", Toast.LENGTH_SHORT).show();
        }

    }

    public void rangePermitido(View view, final Context context, int numJogos){


        int [] valida = new int[15];

        valida[0] = R.id.b1;
        valida[1] = R.id.b2;
        valida[2] = R.id.b3;
        valida[3] = R.id.b4;
        valida[4] = R.id.b5;
        valida[5] = R.id.b6;
        valida[6] = R.id.b7;
        valida[7] = R.id.b8;
        valida[8] = R.id.b9;
        valida[9] = R.id.b10;
        valida[10] = R.id.b11;
        valida[11] = R.id.b12;
        valida[12] = R.id.b13;
        valida[13] = R.id.b14;
        valida[14] = R.id.b15;

        for(int i=0;i<=numJogos - 1;i++) {
            // Limite a digitação
            EditText et = (EditText) view.findViewById(valida[i]);
            et.setFilters(new InputFilter[]{new InputFilterMinMax("1", "60")});

            et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){

                        Toast toast= Toast.makeText(context,
                                "Números de 1 a 60", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();


                    }
                }
            });
        }
    }



    //Gera e valida as bolas
    public int[] jogoMegasena(int numJogos) {
        // gera jogo para validação'
        int[] jogo = preencheArrayJogos(numJogos);
        // ordenar jogo
        jogo = ordenarJogo(jogo);
        // verifica se tem numeros repetidos e subistitui este numero
        jogo = validaJogo(jogo, numJogos);

        return jogo;
    }

    //Redimnsiona array
    public int [] preencheArrayJogos (int numJogos){

        int [] jogo = {sorteiaBola(),sorteiaBola(),sorteiaBola(),sorteiaBola(),sorteiaBola(),sorteiaBola()};
        if (numJogos!=6) {
            jogo = Arrays.copyOf(jogo, numJogos);
            for (int i = 6; i <= numJogos -1; i++) {
                jogo[i] = sorteiaBola();
            }
        }
        return jogo;
    }
    // Verifica e substitui numeros repitidos
    public int[] validaJogo(int[] bolas, int numJogos) {
        int i = 0;
        //Busca numeros repetidos e subistitui por novo numero
        while (i <= numJogos -2) {
            //Verifica numeros repetidos
            if (bolas[i] == bolas[i + 1]) {
                bolas[i] = sorteiaBola();
                bolas = ordenarJogo(bolas);
                i = 0;
            } else {
                i++;
            }
        }
        return bolas;
    }

    //Ordena o jogo em ordem crescente
    public int[] ordenarJogo(int[] bolas) {

        int[] jogoOrdenado = bolas;
        Arrays.sort(jogoOrdenado);

        return jogoOrdenado;
    }

    //Método que sorteia uma bola
    public int sorteiaBola() {
        double bola;
        //Busca um numero de 0 a 60
        bola = Math.random() * 60;
        //Fecha o range de 1 a 60
        bola = bola + 1;
        // cast para inteiro
        int bolaSorteada = (int) bola;
        // Retorna bola sorteada inteiro
        return bolaSorteada;
    }

    // preenche campos com bolar soteadas
    public void preencheBolas(View view) {
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        int numJogotl = Integer.parseInt(spinner.getSelectedItem().toString());
        //Faz o jogo e valida numeros
        int[] sorteio = jogoMegasena(numJogotl);
        // vincula os layouts
        EditText bola1 = (EditText) view.findViewById(R.id.b1);
        EditText bola2 = (EditText) view.findViewById(R.id.b2);
        EditText bola3 = (EditText) view.findViewById(R.id.b3);
        EditText bola4 = (EditText) view.findViewById(R.id.b4);
        EditText bola5 = (EditText) view.findViewById(R.id.b5);
        EditText bola6 = (EditText) view.findViewById(R.id.b6);
        EditText bola7 = (EditText) view.findViewById(R.id.b7);
        EditText bola8 = (EditText) view.findViewById(R.id.b8);
        EditText bola9 = (EditText) view.findViewById(R.id.b9);
        EditText bola10 = (EditText) view.findViewById(R.id.b10);
        EditText bola11 = (EditText) view.findViewById(R.id.b11);
        EditText bola12 = (EditText) view.findViewById(R.id.b12);
        EditText bola13 = (EditText) view.findViewById(R.id.b13);
        EditText bola14 = (EditText) view.findViewById(R.id.b14);
        EditText bola15 = (EditText) view.findViewById(R.id.b15);


        // preenche valor para primeira Bola
        bola1.setText("" + sorteio[0]);
        bola2.setText("" + sorteio[1]);
        bola3.setText("" + sorteio[2]);
        bola4.setText("" + sorteio[3]);
        bola5.setText("" + sorteio[4]);
        bola6.setText("" + sorteio[5]);

       if (numJogotl == 7){
           bola7.setText("" + sorteio[6]);
       }else if (numJogotl == 8){
           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
       }else if (numJogotl == 9){
           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
           bola9.setText("" + sorteio[8]);
       }else if (numJogotl == 10){
           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
           bola9.setText("" + sorteio[8]);
           bola10.setText("" + sorteio[9]);

       }else if (numJogotl == 11){
           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
           bola9.setText("" + sorteio[8]);
           bola10.setText("" + sorteio[9]);
           bola11.setText("" + sorteio[10]);
       }else if (numJogotl == 12){
           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
           bola9.setText("" + sorteio[8]);
           bola10.setText("" + sorteio[9]);
           bola11.setText("" + sorteio[10]);
           bola12.setText("" + sorteio[11]);

       }else if (numJogotl == 13){
           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
           bola9.setText("" + sorteio[8]);
           bola10.setText("" + sorteio[9]);
           bola11.setText("" + sorteio[10]);
           bola12.setText("" + sorteio[11]);
           bola13.setText("" + sorteio[12]);

       }else if (numJogotl == 14){

           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
           bola9.setText("" + sorteio[8]);
           bola10.setText("" + sorteio[9]);
           bola11.setText("" + sorteio[10]);
           bola12.setText("" + sorteio[11]);
           bola13.setText("" + sorteio[12]);
           bola14.setText("" + sorteio[13]);

       }else if (numJogotl == 15){
           bola7.setText("" + sorteio[6]);
           bola8.setText("" + sorteio[7]);
           bola9.setText("" + sorteio[8]);
           bola10.setText("" + sorteio[9]);
           bola11.setText("" + sorteio[10]);
           bola12.setText("" + sorteio[11]);
           bola13.setText("" + sorteio[12]);
           bola14.setText("" + sorteio[13]);
           bola15.setText("" + sorteio[14]);
       }

        // para jogos acima de 6 numeros

    }
    //Limpa bolas quando alterar numero
    public void limpaBolas(View view){
        // vincula os layouts
        EditText bola1 = (EditText) view.findViewById(R.id.b1);
        EditText bola2 = (EditText) view.findViewById(R.id.b2);
        EditText bola3 = (EditText) view.findViewById(R.id.b3);
        EditText bola4 = (EditText) view.findViewById(R.id.b4);
        EditText bola5 = (EditText) view.findViewById(R.id.b5);
        EditText bola6 = (EditText) view.findViewById(R.id.b6);
        EditText bola7 = (EditText) view.findViewById(R.id.b7);
        EditText bola8 = (EditText) view.findViewById(R.id.b8);
        EditText bola9 = (EditText) view.findViewById(R.id.b9);
        EditText bola10 = (EditText) view.findViewById(R.id.b10);
        EditText bola11 = (EditText) view.findViewById(R.id.b11);
        EditText bola12 = (EditText) view.findViewById(R.id.b12);
        EditText bola13 = (EditText) view.findViewById(R.id.b13);
        EditText bola14 = (EditText) view.findViewById(R.id.b14);
        EditText bola15 = (EditText) view.findViewById(R.id.b15);
        bola1.setText("");
        bola2.setText("");
        bola3.setText("");
        bola4.setText("");
        bola5.setText("");
        bola6.setText("");
        bola7.setText("");
        bola8.setText("");
        bola9.setText("");
        bola10.setText("");
        bola11.setText("");
        bola12.setText("");
        bola13.setText("");
        bola14.setText("");
        bola15.setText("");
        // TODO: para jogos acima de 6 numeros
    }

    public void carregaJogos(final Activity activity){

            /*
            * Carrega o listView com os dados da tabela jogos
             */
            mydb = new DBHelper(activity.getApplicationContext());
            final ArrayList<Jogo> jogos = new ArrayList<Jogo>();

            jogos.addAll(mydb.getAllJogos());
            final ArrayAdapter<Jogo> jogoadapter = new jogoAdapter(activity,jogos);
            //final ArrayAdapter<Jogo> jogoadapter = new JogoAdapterHolder(activity,jogos);
            //JogoAdapterHolder adapter = new JogoAdapterHolder(jogos);
            final ListView listView = (ListView) activity.findViewById(R.id.list);
//            listView.setLayoutManager(new LinearLayoutManager(activity));
//            listView.setHasFixedSize(true);
            listView.setAdapter(jogoadapter);

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
