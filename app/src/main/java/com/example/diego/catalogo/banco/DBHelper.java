package com.example.diego.catalogo.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/**
 * Created by dblac on 24/07/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DBName = "CATALOGO";
    private static final int DBVersion = 1;
    private static Context context;
    private ArrayList<ContentValues> produtos;

    public DBHelper(Context context){
        super(context, DBName, null, DBVersion);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptSQL.createProdutos());
        produtos = (ArrayList<ContentValues>) ScriptSQL.preencherBanco(context);
        for(ContentValues cv : produtos){
            db.insertOrThrow("PRODUTOS", null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUTOS");
        onCreate(db);
    }
}
