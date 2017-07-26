package com.example.diego.catalogo.banco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by dblac on 24/07/2017.
 */

public class DBController {
    private SQLiteDatabase db;
    private DBHelper banco;

    public DBController(Context context){
        banco = new DBHelper(context);
    }


    public Cursor listarProdutos(){

        String[] campos = {"CAMINHO", "DESCRICAO"};

        db = banco.getReadableDatabase();

        Cursor cursor = db.query("CATALOGO", campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }

}
