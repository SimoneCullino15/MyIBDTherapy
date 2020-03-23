package com.developer.cullino.myibdtherapy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.developer.cullino.myibdtherapy.DB.DBManager;
import com.developer.cullino.myibdtherapy.Model.Farmaco;

public class NewFarmaco extends AppCompatActivity {

    DBManager db = new DBManager(this);
    private static final String INSERR = "Inserimento non riuscito";
    private static final String NOMERR = "Il nome del farmaco deve essere di almeno 3 caratteri!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_farmaco);
    }


    public void btInserisciPillola_Click(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Inserimento farmaco");
        alertDialogBuilder.setMessage("Proseguire?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String nome = ((EditText)findViewById(R.id.txtNome)).getText().toString();
                String bugiardino = ((EditText)findViewById(R.id.txtBugiardino)).getText().toString();
                inserisciFarmaco(nome, bugiardino, "pillole");
            }
        });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void btInserisciSiringa_Click(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Inserimento farmaco");
        alertDialogBuilder.setMessage("Proseguire?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String nome = ((EditText)findViewById(R.id.txtNome)).getText().toString();
                String bugiardino = ((EditText)findViewById(R.id.txtBugiardino)).getText().toString();
                inserisciFarmaco(nome, bugiardino, "siringa");
            }
        });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void btInserisciBustina_Click(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Inserimento farmaco");
        alertDialogBuilder.setMessage("Proseguire?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String nome = ((EditText)findViewById(R.id.txtNome)).getText().toString();
                String bugiardino = ((EditText)findViewById(R.id.txtBugiardino)).getText().toString();
                inserisciFarmaco(nome, bugiardino, "bustina");
            }
        });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void btInserisciClisma_Click(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Inserimento farmaco");
        alertDialogBuilder.setMessage("Proseguire?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String nome = ((EditText)findViewById(R.id.txtNome)).getText().toString();
                String bugiardino = ((EditText)findViewById(R.id.txtBugiardino)).getText().toString();
                inserisciFarmaco(nome, bugiardino, "clisma");
            }
        });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void btInserisciFlebo_Click(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Inserimento farmaco");
        alertDialogBuilder.setMessage("Proseguire?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String nome = ((EditText)findViewById(R.id.txtNome)).getText().toString();
                String bugiardino = ((EditText)findViewById(R.id.txtBugiardino)).getText().toString();
                inserisciFarmaco(nome, bugiardino, "flebo");
            }
        });
        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void inserisciFarmaco(String nome, String bugiardino, String img){
        if(!datiCorretti(nome))
            return;

        Farmaco farmaco = new Farmaco(nome, bugiardino, img);
        if(db.inserisciFarmaco(farmaco) == -1){
            TextView lblNome = findViewById(R.id.lblNome);
            lblNome.setText(INSERR);
            lblNome.setTextColor(Color.RED);
        }
    }

    public boolean datiCorretti(String nome){
        boolean result = true;
        TextView lblNome = findViewById(R.id.lblNome);
        if(nome == null || nome.length() < 3){
            lblNome.setText(NOMERR);
            lblNome.setTextColor(Color.RED);
            result = false;
        }
        else{
            lblNome.setText("");
        }
        return result;
    }
}
