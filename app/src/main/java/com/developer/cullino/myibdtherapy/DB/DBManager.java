package com.developer.cullino.myibdtherapy.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.developer.cullino.myibdtherapy.Model.Farmaco;
import com.developer.cullino.myibdtherapy.Model.FarmacoNotifica;
import com.developer.cullino.myibdtherapy.Model.Notifica;

import java.util.ArrayList;

public class  DBManager {
    private DbHelper helper;
    private Context context;

    public DBManager(Context ctx){
        helper = new DbHelper(ctx);
        helper.getReadableDatabase();
        helper.getWritableDatabase();
        context = ctx;
    }

    public void deleteTableandRecreate(){
        helper.deleteTableandRecreate();
    }

    public DBManager open(){
        helper.getWritableDatabase();
        return this;
    }

    public ArrayList<Farmaco> getAllFarmaci(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor row = db.query("farmaco",null,null,null,null,null,"id");
        ArrayList<Farmaco> res = new ArrayList<>();
        while(row.moveToNext()){
            Farmaco temp = new Farmaco();
            temp.setId(row.getInt(row.getColumnIndex("id")));
            temp.setNome(row.getString(row.getColumnIndex("nome")));
            temp.setBugiardino(row.getString(row.getColumnIndex("bugiardino")));
            temp.setImg(row.getString(row.getColumnIndex("img")));
            res.add(temp);
        }
        row.close();
        return res;
    }

    public ArrayList<Notifica> getAllNotifiche(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT * FROM notifica;";
        Cursor row = db.rawQuery(query,null);
        ArrayList<Notifica> res = new ArrayList<>();
        while(row.moveToNext()){
            Notifica temp = new Notifica();
            temp.setIdFarmaco(row.getInt(row.getColumnIndex("idFarmaco")));
            temp.setOra(row.getString(row.getColumnIndex("ora")));
            temp.setQuantita(row.getInt(row.getColumnIndex("quantita")));
            temp.setIntervallo(row.getInt(row.getColumnIndex("intervallo")));
            temp.setDaysOff(row.getInt(row.getColumnIndex("daysOff")));
            res.add(temp);
        }
        row.close();
        return res;
    }

    public Farmaco getFarmacoById(int id){
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT * FROM farmaco WHERE id ='"+id+"';";
        Cursor riga = db.rawQuery(query,null);
        Farmaco result = new Farmaco();
        result.setId(riga.getInt(riga.getColumnIndex("id")));
        result.setNome(riga.getString(riga.getColumnIndex("nome")));
        result.setBugiardino(riga.getString(riga.getColumnIndex("bugiardino")));
        result.setImg(riga.getString(riga.getColumnIndex("img")));

        return result;
    }

    public ArrayList<FarmacoNotifica> getFarmacoNotifica(){
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT * FROM notifica,farmaco WHERE farmaco.id = notifica.idFarmaco";
        Cursor righe = db.rawQuery(query,null);
        ArrayList<FarmacoNotifica> res = new ArrayList<>();
        while(righe.moveToNext()){
            Farmaco farmaco = new Farmaco();
            farmaco.setId(righe.getInt(righe.getColumnIndex("id")));
            farmaco.setNome(righe.getString(righe.getColumnIndex("nome")));
            farmaco.setBugiardino(righe.getString(righe.getColumnIndex("bugiardino")));
            farmaco.setImg(righe.getString(righe.getColumnIndex("img")));
            Notifica notifica = new Notifica();
            notifica.setIdFarmaco(righe.getInt(righe.getColumnIndex("id")));
            notifica.setOra(righe.getString(righe.getColumnIndex("ora")));
            notifica.setIntervallo(righe.getInt(righe.getColumnIndex("intervallo")));
            notifica.setDaysOff(righe.getInt(righe.getColumnIndex("daysOff")));
            notifica.setQuantita(righe.getInt(righe.getColumnIndex("quantita")));
            FarmacoNotifica temp = new FarmacoNotifica(farmaco,notifica);
            res.add(temp);
        }
        return res;
    }

    public long inserisciFarmaco(Farmaco farmaco){
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", farmaco.getNome());
        cv.put("bugiardino", farmaco.getBugiardino());
        cv.put("img", farmaco.getImg());
        return db.insert("farmaco", null, cv);
    }

    public long inserisciNotifica(Notifica notifica){
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("idFarmaco", notifica.getIdFarmaco());
        cv.put("ora", notifica.getOra());
        cv.put("quantita", notifica.getQuantita());
        cv.put("intervallo", notifica.getIntervallo());
        cv.put("daysOff", notifica.getIntervallo()); //perche il conto alla rovescia delle notifiche parte da intervallo
        return db.insert("notifica", null, cv);
    }

    public long rimuoviNotifica(Notifica notifica){
        SQLiteDatabase db = helper.getReadableDatabase();
        return db.delete("notifica", "idFarmaco=? AND ora=?", new String[] {String.valueOf(notifica.getIdFarmaco()), notifica.getOra()});
    }

    public long rimuoviFarmaco(Farmaco farmaco){
        SQLiteDatabase db = helper.getReadableDatabase();
        return db.delete("farmaco", "id=?", new String[] {String.valueOf(farmaco.getId())});
    }
}
