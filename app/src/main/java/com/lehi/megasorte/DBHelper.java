package com.lehi.megasorte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "jogos";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NUM_JOGO = "numjogos";
    public static final String CONTACTS_COLUMN_b1 = "b1";
    public static final String CONTACTS_COLUMN_b2 = "b2";
    public static final String CONTACTS_COLUMN_b3 = "b3";
    public static final String CONTACTS_COLUMN_b4 = "b4";
    public static final String CONTACTS_COLUMN_b5 = "b5";
    public static final String CONTACTS_COLUMN_b6 = "b6";
    public static final String CONTACTS_COLUMN_b7 = "b7";
    public static final String CONTACTS_COLUMN_b8 = "b8";
    public static final String CONTACTS_COLUMN_b9 = "b9";
    public static final String CONTACTS_COLUMN_b10 = "b10";
    public static final String CONTACTS_COLUMN_b11 = "b11";
    public static final String CONTACTS_COLUMN_b12 = "b12";
    public static final String CONTACTS_COLUMN_b13 = "b13";
    public static final String CONTACTS_COLUMN_b14 = "b14";
    public static final String CONTACTS_COLUMN_b15 = "b15";


    public static final String PARTICIP_TABLE_NAME = "participantes";
    public static final String PARTICIP_COLUMN_ID = "id";
    public static final String PARTICIP_COLUMN_EMAIL = "email";
    public static final String PARTICIP_COLUMN_NOME = "nome";
    public static final String PARTICIP_COLUMN_PAGO = "pago";



    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table jogos " +
                        "(id integer primary key,numjogos Integer,b1 text,b2 text,b3 text, b4 " +
                        "text,b5 text,b6 text , b7 text,b8 text,b9 text, b10 text, b11 text, b12 " +
                        "text , b13 text, b14 text, b15 text)"
        );

        db.execSQL(
                "create table participantes " +
                        "(id integer primary key, email text,nome text, pago integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS jogos");
        db.execSQL("DROP TABLE IF EXISTS participantes");
        onCreate(db);
    }

    public boolean insertJogos(int numJogo, String b1, String b2, String b3, String b4,String b5,
                               String b6 , String b7,String b8, String b9,String b10, String b11 ,
                               String b12 , String b13,String b14, String b15)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("numjogos", numJogo);
        contentValues.put("b1", b1);
        contentValues.put("b2", b2);
        contentValues.put("b3", b3);
        contentValues.put("b4", b4);
        contentValues.put("b5", b5);
        contentValues.put("b6", b6);

        contentValues.put("b7", b7);
        contentValues.put("b8", b8);
        contentValues.put("b9", b9);
        contentValues.put("b10", b10);
        contentValues.put("b11", b11);
        contentValues.put("b12", b12);
        contentValues.put("b13", b13);
        contentValues.put("b14", b14);
        contentValues.put("b15", b15);



        db.insert("jogos", null, contentValues);
        return true;
    }

    public boolean insertParticipantes(String email, String nome)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("nome", nome);

        db.insert("participantes", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from jogos where id="+id+"", null );
        return res;
    }

    public Cursor getDataParticipantes(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from participantes where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public int numberOfRowsParticpantes(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, PARTICIP_TABLE_NAME);
        return numRows;
    }

    public boolean updateJogos (Integer id, String b1, String b2, String b3, String b4,String b5,String b6)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("b1", b1);
        contentValues.put("b2", b2);
        contentValues.put("b3", b3);
        contentValues.put("b4", b4);
        contentValues.put("b5", b5);
        contentValues.put("b6", b6);
        db.update("jogos", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public boolean updateParticip (Integer id, Integer pago)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pago", Integer.toString(pago));
        db.update("participantes", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteJogos (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("jogos",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }
    public Integer deleteAllJogos ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("jogos",
                null,
                null);
    }


    public Integer deleteParticip(Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("participantes",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }
    public Integer deleteAllParticipantes ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("participantes",
                null,
                null);
    }


    public ArrayList<Jogo> getAllJogos()
    {
        ArrayList<Jogo> jogos = new ArrayList<Jogo>();
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from jogos order by numjogos ", null );
        res.moveToFirst();




        while(res.isAfterLast() == false){

            int id = res.getInt(res.getColumnIndex(CONTACTS_COLUMN_ID));
            int numjogo = res.getInt(res.getColumnIndex(CONTACTS_COLUMN_NUM_JOGO));
            String b1 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b1));
            String b2 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b2));
            String b3 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b3));
            String b4 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b4));
            String b5 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b5));
            String b6 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b6));
            String b7 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b7));
            String b8 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b8));
            String b9 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b9));
            String b10 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b10));
            String b11 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b11));
            String b12 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b12));
            String b13 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b13));
            String b14 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b14));
            String b15 = res.getString(res.getColumnIndex(CONTACTS_COLUMN_b15));

            jogos.add(new Jogo(id,numjogo,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15));
            res.moveToNext();
        }
        return jogos;
    }

    public ArrayList<Participantes> getAllParticipantes()
    {
        ArrayList<Participantes> part = new ArrayList<Participantes>();
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from participantes", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            part.add(new Participantes(res.getInt(res.getColumnIndex(PARTICIP_COLUMN_ID)),res.getString(res.getColumnIndex(PARTICIP_COLUMN_EMAIL)),res.getString(res.getColumnIndex(PARTICIP_COLUMN_NOME)),res.getInt(res
                    .getColumnIndex(PARTICIP_COLUMN_PAGO))));
            res.moveToNext();
        }
        return part;
    }


    public int getnumJogos()
    {
        int totalJogos = 0;
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select count(*) from jogos", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            totalJogos = res.getInt(res.getColumnIndex("count(*)"));
            res.moveToNext();
        }
        return totalJogos;
    }

    public int getnumParticip()
    {
        int totalParticip = 0;
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select count(*) from participantes", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            totalParticip = res.getInt(res.getColumnIndex("count(*)"));
            res.moveToNext();
        }
        return totalParticip;
    }

    public ArrayList<String> getallemail()
    {
        ArrayList<String> listEmail= new ArrayList<String>();
        int totalParticip = 0;
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select email from participantes", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            listEmail.add(res.getString(res.getColumnIndex("email")));
            res.moveToNext();
        }
        return listEmail;
    }

    public int getnumParticipPago()
    {
        int totalParticip = 0;
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select count(*) from participantes where pago=1", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            totalParticip = res.getInt(res.getColumnIndex("count(*)"));
            res.moveToNext();
        }
        return totalParticip;
    }


    public double getvalorJogos()
    {
        double valortotalJogos = 0;

        int numjogo = 0;
        int totalnumjogo = 0;
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select count(numjogos) , numjogos from jogos group by " +
                "numjogos order by numjogos",
                null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            totalnumjogo = res.getInt(res.getColumnIndex("count(numjogos)"));
            numjogo = res.getInt(res.getColumnIndex("numjogos"));
                valortotalJogos = valortotalJogos + (totalnumjogo *  valorTotal(numjogo));
            res.moveToNext();
        }
        return valortotalJogos;
    }

    private double valorTotal (int numbolas){
        double valorseis = 3.50d;
        double valorsete = 24.50d;
        double valoroito = 98.00d;
        double valornove = 294.00d;
        double valordez = 735.00d;
        double valoronze = 1617.00d;
        double valordoze = 3234.00d;
        double valortreze = 6006.00d;
        double valorquatorze = 10510.50d;
        double valorquinze = 17517.50d;

        double valorjogo = 0.0d;
        if(numbolas == 6){
            valorjogo = valorseis;
        }else if (numbolas == 7){
            valorjogo = valorsete;
        }else if (numbolas == 8){
            valorjogo = valoroito;
        }else if (numbolas == 9){
            valorjogo = valornove;
        }else if (numbolas == 10){
            valorjogo = valordez;
        }else if (numbolas == 11){
            valorjogo = valoronze;
        }else if (numbolas == 12){
            valorjogo = valordoze;
        }else if (numbolas == 13){
            valorjogo = valortreze;
        }else if (numbolas == 14){
            valorjogo = valorquatorze;
        }else if (numbolas == 15){
            valorjogo = valorquinze;
        }


        return valorjogo;

    }

}