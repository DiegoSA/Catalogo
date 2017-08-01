package com.example.diego.catalogo.banco;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.suporte.catalogo.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dblac on 24/07/2017.
 */

public class DBController {
    private SQLiteDatabase db;
    private DBHelper banco;

    public DBController(Context context){
        banco = new DBHelper(context);
    }

    public void preencherBanco(Context context) {

        Resources resources = context.getResources();


        try {
            InputStream inputStream = resources.openRawResource(R.raw.produtos);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader lerArq = new BufferedReader(inputStreamReader);
            String linha = lerArq.readLine();
            while (linha != null) {

                String[] dados = linha.split(";");
                int codigo = Integer.valueOf(dados[0]);
                String descricao = dados[1];
                int departamento = Integer.valueOf(dados[2]);
                String caminho = dados[3];
                String padaria = dados[4];
                String mercadinho = dados[5];
                String restaurante = dados[6];
                String clinica = dados[7];
                //String hoteis = dados[8];

                db = banco.getWritableDatabase();
                ContentValues values = ScriptSQL.inserirFotoBanco(codigo, descricao, departamento, caminho, padaria, mercadinho, restaurante, clinica); //Aqui usa o método que fará um insert no banco
                db.insertOrThrow("PRODUTOS", null, values);

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cursor listarProdutos(){

        String[] campos = {"CAMINHO"};

        db = banco.getReadableDatabase();

        Cursor cursor = db.query("PRODUTOS", campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }

}
