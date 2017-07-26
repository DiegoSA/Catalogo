package com.example.diego.catalogo.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dblac on 24/07/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBName = "CATALOGO";
    private static final int DBVersion = 1;

    public DBHelper(Context context){

        super(context, DBName, null, DBVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptSQL.createProdutos());
        db.execSQL(ScriptSQL.createDepartamento());
        db.execSQL(ScriptSQL.createSegmento());
        //db.execSQL(ScriptSQL.inserirFotos());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CATALOGO");
        onCreate(db);
    }
}
