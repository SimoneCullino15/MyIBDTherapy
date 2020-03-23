package com.developer.cullino.myibdtherapy.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper{

    private SQLiteDatabase sqldb;

    public DbHelper(Context context){
        super(context,"MyIBDTherapy",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String queryFarmaco = "CREATE TABLE farmaco" +
                "(" +
                "id integer primary key autoincrement," +
                "nome text not null," +
                "bugiardino text," +
                "img text not null" +
                ")";

        String queryOrario = "CREATE TABLE orario" +
                "(" +
                "ora text primary key" +
                ")";

        String queryNotifica = "CREATE TABLE notifica" +
                "(" +
                "idFarmaco integer," +
                "ora text," +
                "quantita integer not null," +
                "intervallo integer not null," +
                "daysOff integer not null," +
                "CHECK (daysOff <= intervallo)," +
                "CHECK (daysOff >= 0)," +
                "FOREIGN KEY(idFarmaco) REFERENCES farmaco(id)," +
                "FOREIGN KEY(ora) REFERENCES orario(ora)," +
                "PRIMARY KEY (idFarmaco,ora)" +
                ")";

        Log.d("DBHELPER", "inizio creazione DB");

        db.execSQL(queryFarmaco);
        Log.d("DBHELPER", "creo table farmaco");

        db.execSQL(queryOrario);
        Log.d("DBHELPER", "creo table orario");

        db.execSQL(queryNotifica);
        Log.d("DBHELPER", "creo relazione notifica");

        inizializzaDB(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}


    private void inizializzaDB(SQLiteDatabase db) {
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                ContentValues initialOrario1 = new ContentValues();
                initialOrario1.put("ora", "0" + i + ":00");
                ContentValues initialOrario2 = new ContentValues();
                initialOrario2.put("ora", "0" + i + ":30");
                db.insert("orario", null, initialOrario1);
                db.insert("orario", null, initialOrario2);
            } else {
                ContentValues initialOrario1 = new ContentValues();
                initialOrario1.put("ora", i + ":00");
                ContentValues initialOrario2 = new ContentValues();
                initialOrario2.put("ora", i + ":30");
                db.insert("orario", null, initialOrario1);
                db.insert("orario", null, initialOrario2);
            }
        }
        ContentValues initialFarmaco1 = new ContentValues();
        initialFarmaco1.put("nome","Pentacol 1200 mg pastiglie");
        initialFarmaco1.put("bugiardino", "https://www.my-personaltrainer.it/Foglietti-illustrativi/Pentacol.html");
        initialFarmaco1.put("img","cinque");

        ContentValues initialFarmaco2 = new ContentValues();
        initialFarmaco2.put("nome","Cortisone 5 mg");
        initialFarmaco2.put("bugiardino", "https://www.my-personaltrainer.it/Foglietti-illustrativi/Deltacortene.html");
        initialFarmaco2.put("img","uno");

        db.insert("farmaco",null,initialFarmaco1);
        db.insert("farmaco",null,initialFarmaco2);

        ContentValues initialNotifica1 = new ContentValues();
        initialNotifica1.put("idFarmaco","1");
        initialNotifica1.put("ora","12.30");
        initialNotifica1.put("quantita", 1);
        initialNotifica1.put("intervallo",1000);
        initialNotifica1.put("daysOff",1000);

        db.insert("notifica",null,initialNotifica1);
    }

    public void deleteTableandRecreate() {
        if (sqldb == null || !sqldb.isOpen())
            sqldb = getWritableDatabase();
        sqldb.execSQL("DROP TABLE IF EXISTS notifica");
        sqldb.execSQL("DROP TABLE IF EXISTS farmaco");
        sqldb.execSQL("DROP TABLE IF EXISTS orario");
        onCreate(sqldb);
    }
}
